package biz.picosoft.demo.Service;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Facture;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.FactureRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.FactureDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.impl.FactureServiceImpl;
import biz.picosoft.demo.service.mapper.ClientMapper;
import biz.picosoft.demo.service.mapper.FactureMapper;
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
public class FactureServiceTest {
    @Mock
    private FactureRepository factureRepository;

    @Mock
    private FactureMapper factureMapper;

    @InjectMocks
    private FactureServiceImpl factureServiceImpl;


    @Test
    public void CreateFacture() {
        // Mocking dependencies
        Facture facture = Facture.builder()
                .description("electric").build();
        FactureDTO factureDto = FactureDTO.builder()
                .description("electric").build();

        when(factureMapper.toEntity(factureDto)).thenReturn(facture);
        when(factureMapper.toDto(facture)).thenReturn(factureDto);
        when(factureRepository.save(Mockito.any(Facture.class))).thenReturn(facture);

        // Method under test
        FactureDTO savedFacture = factureServiceImpl.save(factureDto);

        // Assertion
        Assertions.assertThat(savedFacture).isNotNull();
    }

    @Test
    public void FindById() {
        Long factureId = 1L;
        Facture facture = Facture.builder().id(1L).nom("pikachu").description("electric").build();
        when(factureRepository.findById((long) factureId)).thenReturn(Optional.ofNullable(facture));

        Optional<FactureDTO> factureReturn = factureServiceImpl.findOne(factureId);

        Assertions.assertThat(factureReturn).isNotNull();
    }

    @Test
    public void UpdateClient() {
        // Arrange
        Long factureId = 1L;
        Facture facture = Facture.builder().id(factureId).serviceFournis("pikachu").description("electric").build();
        FactureDTO factureDto = FactureDTO.builder().id(factureId).serviceFournis("pikachu").description("electric").build();

        // Mocking repository methods
        when(factureRepository.findById(factureId)).thenReturn(Optional.of(facture));
        when(factureRepository.save(facture)).thenReturn(facture);

        // Mocking the mapping from DTO to entity and back
        when(factureMapper.toEntity(factureDto)).thenReturn(facture);
        when(factureMapper.toDto(facture)).thenReturn(factureDto);

        // Act
        FactureDTO updateReturn = factureServiceImpl.update(factureDto);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getServiceFournis()).isEqualTo("pikachu");
    }
    @Test
    public void DeleteById() {
        Long factureId = 1L;
        Facture facture = Facture.builder().id(1L).serviceFournis("pikachu").description("electric").build();

        when(factureRepository.findById(factureId)).thenReturn(Optional.ofNullable(facture));
        doNothing().when(factureRepository).delete(facture);

        assertAll(() -> factureServiceImpl.delete(factureId));
    }

}
