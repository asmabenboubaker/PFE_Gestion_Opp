package biz.picosoft.demo.Workflow.service.mapper;

import biz.picosoft.demo.Workflow.domain.BpmJob;
import biz.picosoft.demo.Workflow.service.dto.BpmJobDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-09T18:54:48+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class BpmJobMapperImpl extends BpmJobMapper {

    @Override
    public BpmJob toEntity(BpmJobDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BpmJob bpmJob = new BpmJob();

        bpmJob.setSysdateCreated( dto.getSysdateCreated() );
        bpmJob.setSyscreatedBy( dto.getSyscreatedBy() );
        bpmJob.setSysupdatedBy( dto.getSysupdatedBy() );
        bpmJob.setSysdateUpdated( dto.getSysdateUpdated() );
        bpmJob.setId( dto.getId() );
        bpmJob.setProcessID( dto.getProcessID() );
        bpmJob.setActivityName( dto.getActivityName() );
        bpmJob.setAssignee( dto.getAssignee() );
        bpmJob.setActivityDueDate( dto.getActivityDueDate() );
        bpmJob.setObjectID( dto.getObjectID() );
        bpmJob.setClassID( dto.getClassID() );
        bpmJob.setEndProcess( dto.getEndProcess() );

        return bpmJob;
    }

    @Override
    public List<BpmJob> toEntity(List<BpmJobDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BpmJob> list = new ArrayList<BpmJob>( dtoList.size() );
        for ( BpmJobDTO bpmJobDTO : dtoList ) {
            list.add( toEntity( bpmJobDTO ) );
        }

        return list;
    }

    @Override
    public List<BpmJobDTO> toDto(List<BpmJob> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BpmJobDTO> list = new ArrayList<BpmJobDTO>( entityList.size() );
        for ( BpmJob bpmJob : entityList ) {
            list.add( toDto( bpmJob ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(BpmJob entity, BpmJobDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getSysdateCreated() != null ) {
            entity.setSysdateCreated( dto.getSysdateCreated() );
        }
        if ( dto.getSyscreatedBy() != null ) {
            entity.setSyscreatedBy( dto.getSyscreatedBy() );
        }
        if ( dto.getSysupdatedBy() != null ) {
            entity.setSysupdatedBy( dto.getSysupdatedBy() );
        }
        if ( dto.getSysdateUpdated() != null ) {
            entity.setSysdateUpdated( dto.getSysdateUpdated() );
        }
        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getProcessID() != null ) {
            entity.setProcessID( dto.getProcessID() );
        }
        if ( dto.getActivityName() != null ) {
            entity.setActivityName( dto.getActivityName() );
        }
        if ( dto.getAssignee() != null ) {
            entity.setAssignee( dto.getAssignee() );
        }
        if ( dto.getActivityDueDate() != null ) {
            entity.setActivityDueDate( dto.getActivityDueDate() );
        }
        if ( dto.getObjectID() != null ) {
            entity.setObjectID( dto.getObjectID() );
        }
        if ( dto.getClassID() != null ) {
            entity.setClassID( dto.getClassID() );
        }
        if ( dto.getEndProcess() != null ) {
            entity.setEndProcess( dto.getEndProcess() );
        }
    }

    @Override
    public BpmJobDTO toDto(BpmJob bpmJob) {
        if ( bpmJob == null ) {
            return null;
        }

        BpmJobDTO bpmJobDTO = new BpmJobDTO();

        bpmJobDTO.setSysdateCreated( bpmJob.getSysdateCreated() );
        bpmJobDTO.setSysdateUpdated( bpmJob.getSysdateUpdated() );
        bpmJobDTO.setSyscreatedBy( bpmJob.getSyscreatedBy() );
        bpmJobDTO.setSysupdatedBy( bpmJob.getSysupdatedBy() );
        bpmJobDTO.setId( bpmJob.getId() );
        bpmJobDTO.setProcessID( bpmJob.getProcessID() );
        bpmJobDTO.setActivityName( bpmJob.getActivityName() );
        bpmJobDTO.setAssignee( bpmJob.getAssignee() );
        bpmJobDTO.setActivityDueDate( bpmJob.getActivityDueDate() );
        bpmJobDTO.setObjectID( bpmJob.getObjectID() );
        bpmJobDTO.setClassID( bpmJob.getClassID() );
        bpmJobDTO.setEndProcess( bpmJob.getEndProcess() );

        return bpmJobDTO;
    }
}
