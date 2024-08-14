package biz.picosoft.demo.Service;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.DomaineRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DomaineDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.impl.DomaineServiceImpl;
import biz.picosoft.demo.service.mapper.ClientMapper;
import biz.picosoft.demo.service.mapper.DomaineMapper;
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
public class DomaineServiceTest {
    @Mock
    private DomaineRepository domaineRepository;

    @Mock
    private DomaineMapper domaineMapper;

    @InjectMocks
    private DomaineServiceImpl domaineServiceImpl;

    @Test
    public void CreateDomaine() {
        // Mocking dependencies
        Domaine domaine = Domaine.builder()
                .nom("pikachu")
                .description("electric").build();
        DomaineDTO domaineDTO = DomaineDTO.builder()
                .nom("pikachu")
                .description("electric").build();

        when(domaineMapper.toEntity(domaineDTO)).thenReturn(domaine);
        when(domaineMapper.toDto(domaine)).thenReturn(domaineDTO);
        when(domaineRepository.save(Mockito.any(Domaine.class))).thenReturn(domaine);

        // Method under test
        DomaineDTO savedClient = domaineServiceImpl.save(domaineDTO);

        // Assertion
        Assertions.assertThat(savedClient).isNotNull();
    }
    @Test
    public void FindById() {
        Long domaineId = 1L;
        Domaine domaine = Domaine.builder().id(1L).nom("pikachu").description("electric").build();
        when(domaineRepository.findById((long) domaineId)).thenReturn(Optional.ofNullable(domaine));

        Optional<DomaineDTO> clientReturn = domaineServiceImpl.findOne(domaineId);

        Assertions.assertThat(clientReturn).isNotNull();
    }

    @Test
    public void UpdateDomaine() {
        // Arrange
        Long clientId = 1L;
        Domaine domaine = Domaine.builder().id(1L).nom("pikachu").description("electric").build();
        DomaineDTO domaineDto = DomaineDTO.builder().id(clientId).nom("pikachu").description("electric").build();

        // Mocking repository methods
        when(domaineRepository.findById(clientId)).thenReturn(Optional.of(domaine));
        when(domaineRepository.save(domaine)).thenReturn(domaine);

        // Mocking the mapping from DTO to entity and back
        when(domaineMapper.toEntity(domaineDto)).thenReturn(domaine);
        when(domaineMapper.toDto(domaine)).thenReturn(domaineDto);

        // Act
        DomaineDTO updateReturn = domaineServiceImpl.update(domaineDto);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getNom()).isEqualTo("pikachu");
    }
    @Test
    public void DeleteById() {
        Long domaineId = 1L;
        Domaine domaine = Domaine.builder().id(1L).nom("pikachu").description("electric").build();

        when(domaineRepository.findById(domaineId)).thenReturn(Optional.ofNullable(domaine));
        doNothing().when(domaineRepository).delete(domaine);

        assertAll(() -> domaineServiceImpl.delete(domaineId));
    }
}
