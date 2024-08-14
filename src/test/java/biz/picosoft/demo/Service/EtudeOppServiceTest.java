package biz.picosoft.demo.Service;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.EtudeOppRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.EtudeOppDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.impl.EtudeOppServiceImpl;
import biz.picosoft.demo.service.mapper.ClientMapper;
import biz.picosoft.demo.service.mapper.EtudeOppMapper;
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
public class EtudeOppServiceTest {
    @Mock
    private EtudeOppRepository etudeOppRepository;

    @Mock
    private EtudeOppMapper etudeOppMapper;

    @InjectMocks
    private EtudeOppServiceImpl etudeOppServiceImpl;


    @Test
    public void CreateClient() {
        // Mocking dependencies
        EtudeOpp etudeOpp = EtudeOpp.builder()
                .description("pikachu")
                .specialite("electric").build();
        EtudeOppDTO etudeOppDto = EtudeOppDTO.builder()
                .description("pikachu")
                .specialite("electric").build();

        when(etudeOppMapper.toEntity(etudeOppDto)).thenReturn(etudeOpp);
        when(etudeOppMapper.toDto(etudeOpp)).thenReturn(etudeOppDto);
        when(etudeOppRepository.save(Mockito.any(EtudeOpp.class))).thenReturn(etudeOpp);

        // Method under test
        EtudeOppDTO savedetudeOpp = etudeOppServiceImpl.save(etudeOppDto);

        // Assertion
        Assertions.assertThat(savedetudeOpp).isNotNull();
    }

    @Test
    public void FindById() {
        Long etudeOppId = 1L;
        EtudeOpp etudeOpp = EtudeOpp.builder().id(1L).description("pikachu")
                .specialite("electric").build();
        when(etudeOppRepository.findById((long) etudeOppId)).thenReturn(Optional.ofNullable(etudeOpp));

        Optional<EtudeOppDTO> etudeOppReturn = etudeOppServiceImpl.findOne(etudeOppId);

        Assertions.assertThat(etudeOppReturn).isNotNull();
    }
    @Test
    public void UpdateEtude() {
        // Arrange
        Long etudeId = 1L;
        EtudeOpp etudeOpp = EtudeOpp.builder().id(etudeId).description("pikachu")
                .specialite("electric").build();
        EtudeOppDTO etudeOppDto = EtudeOppDTO.builder().id(etudeId).description("pikachu")
                .specialite("electric").build();

        // Mocking repository methods
        when(etudeOppRepository.findById(etudeId)).thenReturn(Optional.of(etudeOpp));
        when(etudeOppRepository.save(etudeOpp)).thenReturn(etudeOpp);

        // Mocking the mapping from DTO to entity and back
        when(etudeOppMapper.toEntity(etudeOppDto)).thenReturn(etudeOpp);
        when(etudeOppMapper.toDto(etudeOpp)).thenReturn(etudeOppDto);

        // Act
        EtudeOppDTO updateReturn = etudeOppServiceImpl.update(etudeOppDto);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getDescription()).isEqualTo("pikachu");
    }
    @Test
    public void DeleteById() {
        Long etudeId = 1L;
        EtudeOpp etudeOpp = EtudeOpp.builder().id(1L).description("pikachu")
                .specialite("electric").build();

        when(etudeOppRepository.findById(etudeId)).thenReturn(Optional.ofNullable(etudeOpp));
        doNothing().when(etudeOppRepository).delete(etudeOpp);

        assertAll(() -> etudeOppServiceImpl.delete(etudeId));
    }
}
