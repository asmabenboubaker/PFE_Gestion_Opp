package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.service.dto.ClientDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T15:01:31+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( dto.getId() );
        client.setAdresse( dto.getAdresse() );
        client.setTelephne( dto.getTelephne() );
        client.setEmail( dto.getEmail() );
        client.setDescription( dto.getDescription() );
        client.setNom( dto.getNom() );
        client.setDateInscription( dto.getDateInscription() );
        client.setTypeClient( dto.getTypeClient() );
        client.setNotes( dto.getNotes() );

        return client;
    }

    @Override
    public ClientDTO toDto(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( entity.getId() );
        clientDTO.setAdresse( entity.getAdresse() );
        clientDTO.setTelephne( entity.getTelephne() );
        clientDTO.setEmail( entity.getEmail() );
        clientDTO.setDescription( entity.getDescription() );
        clientDTO.setNom( entity.getNom() );
        clientDTO.setDateInscription( entity.getDateInscription() );
        clientDTO.setTypeClient( entity.getTypeClient() );
        clientDTO.setNotes( entity.getNotes() );

        return clientDTO;
    }

    @Override
    public List<Client> toEntity(List<ClientDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtoList.size() );
        for ( ClientDTO clientDTO : dtoList ) {
            list.add( toEntity( clientDTO ) );
        }

        return list;
    }

    @Override
    public List<ClientDTO> toDto(List<Client> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( entityList.size() );
        for ( Client client : entityList ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Client entity, ClientDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getAdresse() != null ) {
            entity.setAdresse( dto.getAdresse() );
        }
        if ( dto.getTelephne() != null ) {
            entity.setTelephne( dto.getTelephne() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getNom() != null ) {
            entity.setNom( dto.getNom() );
        }
        if ( dto.getDateInscription() != null ) {
            entity.setDateInscription( dto.getDateInscription() );
        }
        if ( dto.getTypeClient() != null ) {
            entity.setTypeClient( dto.getTypeClient() );
        }
        if ( dto.getNotes() != null ) {
            entity.setNotes( dto.getNotes() );
        }
    }
}
