package biz.picosoft.demo.Service;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.OffreRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.OffreDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.impl.OffreServiceImpl;
import biz.picosoft.demo.service.mapper.ClientMapper;
import biz.picosoft.demo.service.mapper.OffreMapper;
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
public class OffreServiceTest {

    @Mock
    private OffreRepository offreRepository;

    @Mock
    private OffreMapper offreMapper;

    @InjectMocks
    private OffreServiceImpl offreServiceImpl;

    @Test
    public void CreateClient() {
        // Mocking dependencies
        Offre offre = Offre.builder()
                .description("pikachu")
                .assignee("electric").build();
        OffreDTO offreDto = OffreDTO.builder()
                .description("pikachu")
                .assignee("electric").build();

        when(offreMapper.toEntity(offreDto)).thenReturn(offre);
        when(offreMapper.toDto(offre)).thenReturn(offreDto);
        when(offreRepository.save(Mockito.any(Offre.class))).thenReturn(offre);

        // Method under test
        OffreDTO savedClient = offreServiceImpl.save(offreDto);

        // Assertion
        Assertions.assertThat(savedClient).isNotNull();
    }

    @Test
    public void FindById() {
        Long offreId = 1L;
        Offre offre = Offre.builder().id(1L).description("pikachu").assignee("electric").build();
        when(offreRepository.findById((long) offreId)).thenReturn(Optional.ofNullable(offre));

        Optional<OffreDTO> offreReturn = offreServiceImpl.findOne(offreId);

        Assertions.assertThat(offreReturn).isNotNull();
    }
    @Test
    public void UpdateOffre() {
        // Arrange
        Long offreId = 1L;
        Offre offre = Offre.builder().id(offreId).assignee("pikachu").description("electric").build();
        OffreDTO offreDto = OffreDTO.builder().id(offreId).assignee("pikachu").description("electric").build();

        // Mocking repository methods
        when(offreRepository.findById(offreId)).thenReturn(Optional.of(offre));
        when(offreRepository.save(offre)).thenReturn(offre);

        // Mocking the mapping from DTO to entity and back
        when(offreMapper.toEntity(offreDto)).thenReturn(offre);
        when(offreMapper.toDto(offre)).thenReturn(offreDto);

        // Act
        OffreDTO updateReturn = offreServiceImpl.update(offreDto);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getAssignee()).isEqualTo("pikachu");
    }

    @Test
    public void DeleteById() {
        Long offreId = 1L;
        Offre offre = Offre.builder().id(1L).assignee("pikachu").description("electric").build();

        when(offreRepository.findById(offreId)).thenReturn(Optional.ofNullable(offre));
        doNothing().when(offreRepository).delete(offre);

        assertAll(() -> offreServiceImpl.delete(offreId));
    }
}
