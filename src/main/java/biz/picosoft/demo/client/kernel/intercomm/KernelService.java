package biz.picosoft.demo.client.kernel.intercomm;

import biz.picosoft.demo.DemoApplication;
import biz.picosoft.demo.client.kernel.model.RulesDTO;
import biz.picosoft.demo.client.kernel.model.acl.AclClass;
import biz.picosoft.demo.client.kernel.model.events.Event;
import biz.picosoft.demo.client.kernel.model.global.*;
import biz.picosoft.demo.client.kernel.model.objects.ObjectState;
import biz.picosoft.demo.client.kernel.model.pm.Role;
import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.domain.enumeration.DemandeStatut;
import ch.qos.logback.classic.LoggerContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Table;
import javax.validation.constraints.Null;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.*;


@Service
public class KernelService {
    public static final String anf_invoice_role_canCreatedemande = "canCreatedemande";
    public static final String anf_invoice_role_canCreateopp = "canCreateOffre";
    public static final String anf_invoice_role_canCreateBC = "canCreateBC";
    public static final String anf_invoice_role_canReaddemande = "canReaddemande";
    public static final String anf_invoice_role_canEditdemande = "canEditdemande";

    public static final String VAR_PROFILE_ANF_INVOICE_USER = "ANF_INVOICE_USER";
    public static final String VAR_PROFILE_ANF_INVOICE_BOC = "ANF_INVOICE_BOC";
    public String checkSecurity(String simpleName, Long id, List<String> sids) {
        return kernelInterface.checkSecurity(simpleName, id, sids);
    }
    public org.json.simple.JSONObject _nextTask(Map<String, Object> variables) {
        return kernelInterface._nextTask(variables);
    }
    public String getInput(String processInstanceId, String name, String type) {
        return kernelInterface.getInput(processInstanceId, name, type);
    }
    public List<String> roles = Arrays.asList(
            anf_invoice_role_canCreatedemande,
            anf_invoice_role_canReaddemande,
            anf_invoice_role_canEditdemande);
    public static final String SEQ_DemandeOpp = "seq_demande_oppurtunite";
    //public static final String VAR_ROLE_ADMIN = "r";
    public void adjustAttachmentSecurity(Long classId,
                                         Long objectId,
                                         Integer objectDatasecuriteLevel) {
        kernelInterface.adjustAttachmentSecurity(classId, objectId, objectDatasecuriteLevel);
    }
    public Optional<ObjectState> getObjectState(Long objectId, String classname) {
        return kernelInterface.getObjectState(classname, objectId);
    }
    public org.json.simple.JSONObject startProcessInstance(Map<String, Object> variables) {
        return kernelInterface.startProcessInstance(variables);
    }

    public String encryptFileAccessToken(String strToEncrypt) {
        return kernelInterface.encryptFileAccessToken(strToEncrypt);
    }
    private final Logger log = LoggerFactory.getLogger(KernelService.class);
    private final KernelInterface kernelInterface;

    //public List<String> roles = Arrays.asList(VAR_ROLE_ADMIN, VAR_ROLE_CUSTOMER);
//    public List<String> sequanceList = new ArrayList<>(Arrays.asList(SEQ_DemandeOpp));
    public List<String> sequanceList = new ArrayList<>(Collections.singletonList(SEQ_DemandeOpp));

    public KernelService(KernelInterface kernelInterface) {
        this.kernelInterface = kernelInterface;
    }

    public String Authorize(AuthUser a) {
        return kernelInterface.Authorize(a);
    }

    public CurrentUser getCurrentUser() {
        return kernelInterface.getCurrentUser();
    }
    public List<Role> findAllByProfiles(@RequestParam String name) {
        return kernelInterface.findAllByProfiles(name);
    }

    public String getToken(String apiKey) {
        return kernelInterface.getToken(apiKey);
    }

    public Event addEvent(String eventName, @Null Object data, Long objectID, String classname) throws JsonProcessingException {
        if (data != null) {
            String json = ObjectToString(data);
            return kernelInterface.addEvent(eventName, json, objectID, classname, null, null, null);
        } else
            return kernelInterface.addEvent(eventName, "", objectID, classname, null, null, null);
    }


    public String ObjectToString(Object data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule()).setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String json = mapper.writeValueAsString(data);
        return json;
    }

    public AclClass getAclClassByClassname(String classname) {
        return kernelInterface.getaclClassByClassName(classname);
    }

    public void initClass(InitClass initClass, String tableName, String shemaName) {
        initClass.setPackagename(DemoApplication.packagename);
        kernelInterface.initClass(initClass, tableName, shemaName);
    }

    public String getSequenceNumber(JSONObject jsonObject, String fullClassName) {
        return kernelInterface.getSequenceNumber(jsonObject, fullClassName);
    }

    public StateWorkflow getCurrentState(String className, Long objectId) {
        return kernelInterface.getCurrentState(className, objectId);
    }

    public Boolean applySecurity(String clazz, Long id,
                                 List<String> authors,
                                 List<String> readers,
                                 List<String> tempReaders,
                                 String clazzParent, Long idParent,
                                 Boolean isCreated, Boolean isCumulative) {
        return kernelInterface.applySecurity(
                clazz, id, authors, readers, tempReaders, clazzParent, idParent, isCreated, isCumulative);
    }

    public void setDefaultState(Long objectId, String className) {
        kernelInterface.setDefaultState(objectId, className);
    }

    @Bean
    public void initModule() {
        try {
            InitModule initModule = new InitModule();
            List<String> className = new ArrayList<>();
            //className.add(PoBox.class.getName());

            initModule.setDefaultName("Opp");
            initModule.setPackageName(DemoApplication.packagename);
            initModule.setAclClass(className);
            initModule.setSchema("opportunite");
            initModule.setVersion(getBuildNumber());
            kernelInterface.initModule(initModule);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }



    @Bean
    public void addClassDemande() {
        try {
            InitClass initClass = new InitClass();
            initClass.setSimpleName(Demande.class.getSimpleName());
            initClass.setName(Demande.class.getName());

            HashMap<String, String> event = new HashMap<>();
            HashMap<String, String> state = new HashMap<>();

            for (DemandeStatut s : DemandeStatut.values()) {
                state.put(s.name(), s.getLabel());
            }
//            for (DemandeEvent s : DemandeEvent.values()) {
//                event.put(s.name(), s.getLabel());
//            }
            initClass.setEvent(event);
            initClass.setState(state);
     initClass.setDefaultState(DemandeStatut.DRAFT.name());

            String tableName = Class.forName(initClass.getName()).getAnnotation(Table.class).name();
            String schemaName = Class.forName(initClass.getName()).getAnnotation(Table.class).schema();
            initClass(initClass, tableName, schemaName);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
    @Bean
    public void addClassOpportunite() {
        try {
            InitClass initClass = new InitClass();
            initClass.setSimpleName(Opportunite.class.getSimpleName());
            initClass.setName(Opportunite.class.getName());

            HashMap<String, String> event = new HashMap<>();
            HashMap<String, String> state = new HashMap<>();

            for (DemandeStatut s : DemandeStatut.values()) {
                state.put(s.name(), s.getLabel());
            }
//            for (DemandeEvent s : DemandeEvent.values()) {
//                event.put(s.name(), s.getLabel());
//            }
            initClass.setEvent(event);
            initClass.setState(state);
            initClass.setDefaultState(DemandeStatut.DRAFT.name());

            String tableName = Class.forName(initClass.getName()).getAnnotation(Table.class).name();
            String schemaName = Class.forName(initClass.getName()).getAnnotation(Table.class).schema();
            initClass(initClass, tableName, schemaName);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
    @Bean
    public void addClassBC() {
        try {
            InitClass initClass = new InitClass();
            initClass.setSimpleName(BonDeCommande.class.getSimpleName());
            initClass.setName(BonDeCommande.class.getName());

            HashMap<String, String> event = new HashMap<>();
            HashMap<String, String> state = new HashMap<>();

            for (DemandeStatut s : DemandeStatut.values()) {
                state.put(s.name(), s.getLabel());
            }
//            for (DemandeEvent s : DemandeEvent.values()) {
//                event.put(s.name(), s.getLabel());
//            }
            initClass.setEvent(event);
            initClass.setState(state);
            initClass.setDefaultState(DemandeStatut.DRAFT.name());

            String tableName = Class.forName(initClass.getName()).getAnnotation(Table.class).name();
            String schemaName = Class.forName(initClass.getName()).getAnnotation(Table.class).schema();
            initClass(initClass, tableName, schemaName);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

//    @Bean
//    public void addClassOffre() {
//        try {
//            InitClass initClass = new InitClass();
//            initClass.setSimpleName(Offre.class.getSimpleName());
//            initClass.setName(Offre.class.getName());
//
//            HashMap<String, String> event = new HashMap<>();
//            HashMap<String, String> state = new HashMap<>();
//
//            for (DemandeStatut s : DemandeStatut.values()) {
//                state.put(s.name(), s.getLabel());
//            }
////            for (DemandeEvent s : DemandeEvent.values()) {
////                event.put(s.name(), s.getLabel());
////            }
//            initClass.setEvent(event);
//            initClass.setState(state);
//            initClass.setDefaultState(DemandeStatut.DRAFT.name());
//
//            String tableName = Class.forName(initClass.getName()).getAnnotation(Table.class).name();
//            String schemaName = Class.forName(initClass.getName()).getAnnotation(Table.class).schema();
//            initClass(initClass, tableName, schemaName);
//        } catch (Exception e) {
//            log.error(e.toString());
//        }
//    }

    public String getBuildNumber() {
        Properties properties = new Properties();
        try {
            File file = ResourceUtils.getFile("classpath:build.properties");
            InputStream in = new FileInputStream(file);
            properties.load(in);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        String build = properties.getProperty("build.version");
        return build;
    }

//    @Bean
//    public void initVaraible() {
//        try {
//            InitVariable initVariable = new InitVariable();
//
//            List<Variable> variable = new ArrayList<>();
//            variable.add(new Variable(VAR_PROFILE_MM_BO, "'" + VAR_PROFILE_MM_BO + "'"));
//
//            initVariable.setVariable(variable);
//            initVariable.setRoleName(roles);
//
//            List<InitVariable.InitProfile> profiles = new ArrayList<>();
//            profiles.add(new InitVariable.InitProfile(VAR_PROFILE_MM_BO, new String[]{mm_role_canAssignTag, mm_role_canCreateOutbound, mm_role_canCreateInternal, mm_role_canCreateInbound}));
//
//            initVariable.setProfiles(profiles);
//            kernelInterface.initVaraible(initVariable);
//        } catch (Exception e) {
//       log.error(e.toString());
//        }
//    }

    @Bean
    public void initSequance() {
        for (String s : sequanceList) {
            try {
                String character = s.split("_")[1].substring(0, 1);
                RefSequenceFormat refSequenceFormat = new RefSequenceFormat();
                refSequenceFormat.setName(s);
                refSequenceFormat.setCounter(1L);
                refSequenceFormat.setdescription(s);
                refSequenceFormat.setStep(1);
                refSequenceFormat.setCounterDate(ZonedDateTime.now());
                refSequenceFormat.setResetInterval(ResetInterval.NEVER);
                refSequenceFormat.setFormat(character + "_${counter?string[\"0000\"]}");
                kernelInterface.createRefSequenceFormat(refSequenceFormat);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

//    @Bean
//    public void BeanTenant() {
//        try {
//            InitClass initClass = new InitClass();
//            initClass.setSimpleName(Tenant.class.getSimpleName());
//            initClass.setName(Tenant.class.getName());
//
//            HashMap<String, String> event = new HashMap<>();
//            HashMap<String, String> state = new HashMap<>();
//
//            for (StateClient s : StateClient.values()) {
//                state.put(s.name(), s.getLabel());
//            }
//            for (EventClient s : EventClient.values()) {
//                event.put(s.name(), s.getLabel());
//            }
//            initClass.setEvent(event);
//            initClass.setState(state);
//            initClass.setDefaultState(StateClient.ACTIVE.name());
//
//            String tableName = Class.forName(initClass.getName()).getAnnotation(Table.class).name();
//            String schemaName = Class.forName(initClass.getName()).getAnnotation(Table.class).schema();
//            initClass.setSequenceNameFM(GlobalService.SEQ_TENANT);
//            initClass(initClass, tableName, schemaName);
//        } catch (Exception e) {
//            log.error(e.toString());
//        }
//    }


    public ObjectState saveObjectState(ObjectState objectState) {

        return kernelInterface.saveObjectState(objectState);
    }

    public Optional<ObjectState> getObjectStateCourrier(Long objectId, String classname) {
        return kernelInterface.getObjectState(classname, objectId);
    }
    public RulesDTO rulesByName(String ruleName) {
        return kernelInterface.rulesByName(ruleName);

    }


    public String mapObjectToString(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new SimpleModule().addSerializer(LoggerContext.class, new JsonSerializer<LoggerContext>() {
                    @Override
                    public void serialize(LoggerContext loggerContext, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

                    }
                }))
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule()).setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat());
        return mapper.writeValueAsString(o);
    }
}
