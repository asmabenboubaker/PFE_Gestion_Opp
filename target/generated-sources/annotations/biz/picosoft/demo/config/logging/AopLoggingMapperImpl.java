package biz.picosoft.demo.config.logging;

import biz.picosoft.demo.config.logging.domain.AopLogging;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-08T10:29:10+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class AopLoggingMapperImpl implements AopLoggingMapper {

    @Override
    public AopLogging toEntity(AopLoggingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AopLogging aopLogging = new AopLogging();

        aopLogging.setId( dto.getId() );
        aopLogging.setMicroserviceName( dto.getMicroserviceName() );
        aopLogging.setMethodName( dto.getMethodName() );
        aopLogging.setUuid( dto.getUuid() );
        aopLogging.setPackageFullName( dto.getPackageFullName() );
        aopLogging.setPackageTitle( dto.getPackageTitle() );
        aopLogging.setDuration( dto.getDuration() );
        aopLogging.setUserName( dto.getUserName() );
        aopLogging.setUniteName( dto.getUniteName() );

        return aopLogging;
    }

    @Override
    public AopLoggingDTO toDto(AopLogging entity) {
        if ( entity == null ) {
            return null;
        }

        AopLoggingDTO aopLoggingDTO = new AopLoggingDTO();

        aopLoggingDTO.setId( entity.getId() );
        aopLoggingDTO.setMicroserviceName( entity.getMicroserviceName() );
        aopLoggingDTO.setMethodName( entity.getMethodName() );
        aopLoggingDTO.setUuid( entity.getUuid() );
        aopLoggingDTO.setPackageFullName( entity.getPackageFullName() );
        aopLoggingDTO.setPackageTitle( entity.getPackageTitle() );
        aopLoggingDTO.setDuration( entity.getDuration() );
        aopLoggingDTO.setUserName( entity.getUserName() );
        aopLoggingDTO.setUniteName( entity.getUniteName() );

        return aopLoggingDTO;
    }

    @Override
    public List<AopLogging> toEntity(List<AopLoggingDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AopLogging> list = new ArrayList<AopLogging>( dtoList.size() );
        for ( AopLoggingDTO aopLoggingDTO : dtoList ) {
            list.add( toEntity( aopLoggingDTO ) );
        }

        return list;
    }

    @Override
    public List<AopLoggingDTO> toDto(List<AopLogging> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AopLoggingDTO> list = new ArrayList<AopLoggingDTO>( entityList.size() );
        for ( AopLogging aopLogging : entityList ) {
            list.add( toDto( aopLogging ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(AopLogging entity, AopLoggingDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getMicroserviceName() != null ) {
            entity.setMicroserviceName( dto.getMicroserviceName() );
        }
        if ( dto.getMethodName() != null ) {
            entity.setMethodName( dto.getMethodName() );
        }
        if ( dto.getUuid() != null ) {
            entity.setUuid( dto.getUuid() );
        }
        if ( dto.getPackageFullName() != null ) {
            entity.setPackageFullName( dto.getPackageFullName() );
        }
        if ( dto.getPackageTitle() != null ) {
            entity.setPackageTitle( dto.getPackageTitle() );
        }
        if ( dto.getDuration() != null ) {
            entity.setDuration( dto.getDuration() );
        }
        if ( dto.getUserName() != null ) {
            entity.setUserName( dto.getUserName() );
        }
        if ( dto.getUniteName() != null ) {
            entity.setUniteName( dto.getUniteName() );
        }
    }
}
