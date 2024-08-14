package biz.picosoft.demo.Service;


import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.OpportuniteRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.impl.OpportuniteServiceImpl;
import biz.picosoft.demo.service.mapper.ClientMapper;
import biz.picosoft.demo.service.mapper.OpportuniteMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OpportuniteServiceTest {
    @Mock
    private OpportuniteRepository opportuniteRepository;

    @Mock
    private OpportuniteMapper opportuniteMapper;

    @InjectMocks
    private OpportuniteServiceImpl opportuniteServiceImpl;

    @Test
    public void CreateOpp() {
        // Mocking dependencies
        Opportunite opp = Opportunite.builder()
                .nom("pikachu")
                .description("electric").build();
        OpportuniteDTO oppDto = OpportuniteDTO.builder()
                .nom("pikachu")
                .description("electric").build();

        when(opportuniteMapper.toEntity(oppDto)).thenReturn(opp);
        when(opportuniteMapper.toDto(opp)).thenReturn(oppDto);
        when(opportuniteRepository.save(Mockito.any(Opportunite.class))).thenReturn(opp);

        // Method under test
       OpportuniteDTO  savedOpp = opportuniteServiceImpl.save(oppDto);

        // Assertion
        Assertions.assertThat(savedOpp).isNotNull();
    }
    @Test
    public void FindById() {
        Long OppId = 1L;
        Opportunite opp = Opportunite.builder().id(1L).nom("pikachu").description("electric").assignee("this is a type").build();
        when(opportuniteRepository.findById((long) OppId)).thenReturn(Optional.ofNullable(opp));

        Optional<OpportuniteDTO> oppReturn = opportuniteServiceImpl.findOne(OppId);

        Assertions.assertThat(oppReturn).isNotNull();
    }
    @Test
    public void UpdateOpp() {
        // Arrange
        Long OppId = 1L;
        Opportunite opp = Opportunite.builder().id(1L).nom("pikachu").description("electric").assignee("this is a type").build();
        OpportuniteDTO oppDto = OpportuniteDTO.builder().id(OppId).nom("pikachu").description("electric").build();

        // Mocking repository methods
        when(opportuniteRepository.findById(OppId)).thenReturn(Optional.of(opp));
        when(opportuniteRepository.save(opp)).thenReturn(opp);

        // Mocking the mapping from DTO to entity and back
        when(opportuniteMapper.toEntity(oppDto)).thenReturn(opp);
        when(opportuniteMapper.toDto(opp)).thenReturn(oppDto);

        // Act
        OpportuniteDTO updateReturn = opportuniteServiceImpl.update(oppDto);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getNom()).isEqualTo("pikachu");
    }

    @Test
    public void DeleteoppById() {
        Long oppId = 1L;
        Opportunite opp = Opportunite.builder().id(1L).nom("pikachu").assignee("electric").description("this is a type").build();

        when(opportuniteRepository.findById(oppId)).thenReturn(Optional.ofNullable(opp));
        doNothing().when(opportuniteRepository).delete(opp);

        assertAll(() -> opportuniteServiceImpl.delete(oppId));
    }
}
