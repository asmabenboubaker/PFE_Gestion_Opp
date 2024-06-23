package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.Constants.Constants;
import biz.picosoft.demo.domain.Facture;
import biz.picosoft.demo.domain.InvoiceItem;
import biz.picosoft.demo.domain.PV;
import biz.picosoft.demo.repository.FactureRepository;
import biz.picosoft.demo.repository.PVRepository;
import biz.picosoft.demo.service.FactureService;
import biz.picosoft.demo.service.dto.FactureDTO;
import biz.picosoft.demo.service.mapper.FactureMapper;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.netflix.servo.util.Strings;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.validation.Valid;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Stream;

/**
 * Service Implementation for managing {@link Facture}.
 */
@Service
@Transactional

public class FactureServiceImpl implements FactureService {

    private final Logger log = LoggerFactory.getLogger(FactureServiceImpl.class);

    private final FactureRepository factureRepository;

    private final FactureMapper factureMapper;
    private final PVRepository pvRepository;

    public FactureServiceImpl(FactureRepository factureRepository, FactureMapper factureMapper,
    PVRepository pvRepository
    ) {
        this.factureRepository = factureRepository;
        this.factureMapper = factureMapper;
        this.pvRepository= pvRepository;
    }

    @Override
    public FactureDTO save(FactureDTO factureDTO) {
        log.debug("Request to save Facture : {}", factureDTO);
        Facture facture = factureMapper.toEntity(factureDTO);
        facture = factureRepository.save(facture);
        return factureMapper.toDto(facture);
    }

    @Override
    public FactureDTO update(FactureDTO factureDTO) {
        log.debug("Request to save Facture : {}", factureDTO);
        Facture facture = factureMapper.toEntity(factureDTO);
        facture = factureRepository.save(facture);
        return factureMapper.toDto(facture);
    }

    @Override
    public Optional<FactureDTO> partialUpdate(FactureDTO factureDTO) {
        log.debug("Request to partially update Facture : {}", factureDTO);

        return factureRepository
            .findById(factureDTO.getId())
            .map(existingFacture -> {
                factureMapper.partialUpdate(existingFacture, factureDTO);

                return existingFacture;
            })
            .map(factureRepository::save)
            .map(factureMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FactureDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Factures");
        return factureRepository.findAll(pageable).map(factureMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FactureDTO> findOne(Long id) {
        log.debug("Request to get Facture : {}", id);
        return factureRepository.findById(id).map(factureMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Facture : {}", id);
        factureRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<String> generateReport(Map<String, Object> requestMap) {

       log.info("Request to generate report ");
        try{
    String fileName;
    if(ValidateRequestMap(requestMap)){
        log.error("VALIDATION ANTAR " + ValidateRequestMap(requestMap));
        if(requestMap.containsKey("isGenerate") && !(boolean) requestMap.get("isGenerate")){
            fileName = (String) requestMap.get("uuid");
        }
        else {
            fileName=getUUID();
            requestMap.put("uuid",fileName);
            insertBill(requestMap);
        }
        String data= "Name : "+requestMap.get("nom")+"\n"+
                "Date : "+new Date()+"\n"+
                "Description : "+requestMap.get("description")+"\n"+
                "Service Fournis : "+requestMap.get("serviceFournis")+"\n"+
                "Payment Method : "+requestMap.get("PaymentMethod")+"\n"+
                "Total Amount : "+requestMap.get("totalAmount")+"\n"+
                "Contact Number : "+requestMap.get("contactNumber")+"\n";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(Constants.STORE_LOCATION+"\\"+fileName+".pdf"));
        document.open();
        setRectangleInPDF(document);
        Paragraph chunk=new Paragraph("Facture ",getFront("Header") );
        chunk.setAlignment(Element.ALIGN_CENTER);
        document.add(chunk);
        Paragraph paragraph=new Paragraph(data+"\n \n",getFront("Data"));
        document.add(paragraph);
        PdfPTable table =new PdfPTable(5);
        table.setWidthPercentage(100);
        addTableHeader(table);
//        JSONArray jsonArray=getJsonArray((String) requestMap.get("pv"));
//            for(int i=0;i<jsonArray.length();i++){
//                addRows(table,getMapFromJson(jsonArray.getString(i)));
//                  }
            document.add(table);
            Paragraph footer = new Paragraph("total"+
                    requestMap.get("totalAmount")+"\n"+
                    "thank you for your business",getFront("Data"));
            document.add(footer);
            document.close();
            return new ResponseEntity<>("{\"fileName\":\""+fileName+"\"}", HttpStatus.OK);
    }


        }catch (Exception e){

            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Error");
    }

    @Override
    public ResponseEntity<String> affectFactureToPv(Facture facture, Long idPv) {
        // ajouter Facture et affecter pv
        PV pv = pvRepository.findById(idPv).get();
        facture.setPv(pv);
        factureRepository.save(facture);
        return new ResponseEntity<>("Facture affectée avec succès", HttpStatus.OK);


    }

    @Override
    @Transactional
    public Facture saveFactureWithItems(Facture facture, Set<InvoiceItem> invoiceItems) {
        try {
            for (InvoiceItem item : invoiceItems) {
                facture.addInvoiceItem(item);
            }
            facture.setInvoiceItems(invoiceItems);

            // Logging des détails de facture et des items
            log.info("Facture avant sauvegarde : {}", facture);
            log.info("Items avant sauvegarde : {}", invoiceItems);

            // Sauvegarde de la Facture avec les InvoiceItems
            return factureRepository.save(facture);
        } catch (Exception e) {
            log.error("Erreur lors de la sauvegarde de la facture avec les items", e);
            throw new RuntimeException("Erreur lors de la sauvegarde de la facture avec les items", e);
        }
    }

    @Override
    public Set<InvoiceItem> getItemsByFactureId(Long id) {
        try {
            Optional<Facture> facture = factureRepository.findById(id);
            if (facture.isPresent()) {
                return facture.get().getInvoiceItems();
            } else {
                return new HashSet<>();
            }
        } catch (Exception e) {
            log.error("Erreur lors de la récupération des items de la facture", e);
            throw new RuntimeException("Erreur lors de la récupération des items de la facture", e);
        }

    }

    private void addRows(PdfPTable table, Map<String, Object> mapFromJson) {

    log.info("Inside addRows");
        table.addCell(new PdfPCell(new Phrase((String) mapFromJson.get("name"))));
        table.addCell(new PdfPCell(new Phrase((String) mapFromJson.get("description"))));
        table.addCell(new PdfPCell(new Phrase((String) mapFromJson.get("serviceFournis"))));
        table.addCell(new PdfPCell(new Phrase((String) mapFromJson.get("PaymentMethod"))));
        table.addCell(new PdfPCell(new Phrase((String) mapFromJson.get("totalAmount"))));
        table.addCell(new PdfPCell(new Phrase((String) mapFromJson.get("contactNumber"))));
    }

    private void addTableHeader(PdfPTable table) {
        log.info("Inside addTableHeader");
        Stream.of("Name","Description","Service Fournis","Payment Method","Total Amount","Contact Number")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setVerticalAlignment(Element.ALIGN_CENTER);

                    table.addCell(header);
                });
    }

    private Font getFront(String type) {
        log.info("Inside getFront");
        switch (type){
            case "Header":
                Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE,18,BaseColor.BLACK);
                font.setStyle(Font.BOLD);

                return font;
            case "Data":
                Font dataFront=FontFactory.getFont(FontFactory.TIMES_ROMAN,11,BaseColor.BLACK);
                dataFront.setStyle(Font.BOLD);
                return dataFront;
            default:
                return new Font();
        }

    }

    private void setRectangleInPDF(Document document) throws Exception {
      log.info("Inside setRectangleInPDF");
        Rectangle rect= new Rectangle(577, 825,18,15);
        rect.enableBorderSide(1);
        rect.enableBorderSide(2);
        rect.enableBorderSide(4);
        rect.enableBorderSide(8);
        rect.setBorderColor(BaseColor.BLACK);
        rect.setBorderWidth(1);
        document.add(rect);
    }

    private void insertBill(Map<String, Object> requestMap) {
        try
        {
            Facture facture = new Facture();
            facture.setUuid((String) requestMap.get("uuid"));
            facture.setNom((String) requestMap.get("nom"));
            facture.setDescription((String) requestMap.get("description"));
            facture.setServiceFournis((String) requestMap.get("serviceFournis"));
            // set date to date today
            ZonedDateTime now = ZonedDateTime.now();
            facture.setDateFacture(LocalDate.from(now));

            //facture.setDateFacture((Date) requestMap.get("dateFacture"));
            //facture.setPv((PV) requestMap.get("pv"));
            facture.setPaymentMethod((String) requestMap.get("PaymentMethod"));
            facture.setTotalAmount(((Number) requestMap.get("totalAmount")).floatValue());
            facture.setContactNumber((String) requestMap.get("contactNumber"));

            factureRepository.save(facture);


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private boolean ValidateRequestMap(Map<String, Object> requestMap) {

return requestMap.containsKey("nom") &&
        requestMap.containsKey("description") &&
        requestMap.containsKey("serviceFournis") &&
//        requestMap.containsKey("dateFacture") &&
//        requestMap.containsKey("pv") &&
        requestMap.containsKey("PaymentMethod")&&
        requestMap.containsKey("totalAmount")&&
        requestMap.containsKey("contactNumber");



    }

public static String getUUID(){
    Date date =new Date();
    long time=date.getTime();
    return "Bill-"+time;
}
public static JSONArray getJsonArray(String data) {
    return new JSONArray(data);
}
public static Map<String, Object> getMapFromJson(String data) {
        if(!Strings.isNullOrEmpty(data)){
            return new Gson().fromJson(data,new TypeToken<Map<String,Object>>(){
            }.getType());

            } return new HashMap<>();
    }
}

