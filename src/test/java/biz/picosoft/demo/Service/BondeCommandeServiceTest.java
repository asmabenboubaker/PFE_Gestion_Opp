package biz.picosoft.demo.Service;

import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.repository.BonDeCommandeRepository;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DomaineDTO;
import biz.picosoft.demo.service.impl.BonDeCommandeServiceImpl;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.mapper.BonDeCommandeMapper;
import biz.picosoft.demo.service.mapper.ClientMapper;
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
public class BondeCommandeServiceTest {
    @Mock
    private BonDeCommandeRepository bonDeCommandeRepository;

    @Mock
    private BonDeCommandeMapper bonDeCommandeMapper;

    @InjectMocks
    private BonDeCommandeServiceImpl bonDeCommandeServiceImpl;

    @Test
    public void CreateBC() {
        // Mocking dependencies
        BonDeCommande bd = BonDeCommande.builder()
                .assignee("pikachu")
                .description("electric").build();
        BonDeCommandeDTO bdDto = BonDeCommandeDTO.builder()
                .assignee("pikachu")
                .description("electric").build();

        when(bonDeCommandeMapper.toEntity(bdDto)).thenReturn(bd);
        when(bonDeCommandeMapper.toDto(bd)).thenReturn(bdDto);
        when(bonDeCommandeRepository.save(Mockito.any(BonDeCommande.class))).thenReturn(bd);

        // Method under test
        BonDeCommandeDTO savedBD = bonDeCommandeServiceImpl.save(bdDto);

        // Assertion
        Assertions.assertThat(savedBD).isNotNull();
    }
    @Test
    public void FindById() {
        Long bcId = 1L;
        BonDeCommande bonDeCommande = BonDeCommande.builder().id(1L).assignee("pikachu")
                .description("electric").build();
        when(bonDeCommandeRepository.findById((long) bcId)).thenReturn(Optional.ofNullable(bonDeCommande));

        Optional<BonDeCommandeDTO> clientReturn = bonDeCommandeServiceImpl.findOne(bcId);

        Assertions.assertThat(clientReturn).isNotNull();
    }
    @Test
    public void UpdateBC() {
        // Arrange
        Long bcId = 1L;
        BonDeCommande bonDeCommande = BonDeCommande.builder().id(1L).assignee("pikachu")
                .description("electric").build();
        BonDeCommandeDTO bonDeCommandeDTO = BonDeCommandeDTO.builder().id(bcId).assignee("pikachu")
                .description("electric").build();

        // Mocking repository methods
        when(bonDeCommandeRepository.findById(bcId)).thenReturn(Optional.of(bonDeCommande));
        when(bonDeCommandeRepository.save(bonDeCommande)).thenReturn(bonDeCommande);

        // Mocking the mapping from DTO to entity and back
        when(bonDeCommandeMapper.toEntity(bonDeCommandeDTO)).thenReturn(bonDeCommande);
        when(bonDeCommandeMapper.toDto(bonDeCommande)).thenReturn(bonDeCommandeDTO);

        // Act
        BonDeCommandeDTO updateReturn = bonDeCommandeServiceImpl.update(bonDeCommandeDTO);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getAssignee()).isEqualTo("pikachu");
    }
    @Test
    public void UpdateClient() {
        // Arrange
        Long bcId = 1L;
        BonDeCommande client = BonDeCommande.builder().id(bcId).assignee("pikachu")
                .description("electric").build();
        BonDeCommandeDTO clientIdDto = BonDeCommandeDTO.builder().id(bcId).assignee("pikachu")
                .description("electric").build();

        // Mocking repository methods
        when(bonDeCommandeRepository.findById(bcId)).thenReturn(Optional.of(client));
        when(bonDeCommandeRepository.save(client)).thenReturn(client);

        // Mocking the mapping from DTO to entity and back
        when(bonDeCommandeMapper.toEntity(clientIdDto)).thenReturn(client);
        when(bonDeCommandeMapper.toDto(client)).thenReturn(clientIdDto);

        // Act
        BonDeCommandeDTO updateReturn = bonDeCommandeServiceImpl.update(clientIdDto);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getAssignee()).isEqualTo("pikachu");
    }

    @Test
    public void DeleteById() {
        Long clientId = 1L;
        BonDeCommande client = BonDeCommande.builder().id(1L).assignee("pikachu")
                .description("electric").build();

        when(bonDeCommandeRepository.findById(clientId)).thenReturn(Optional.ofNullable(client));
        doNothing().when(bonDeCommandeRepository).delete(client);

        assertAll(() -> bonDeCommandeServiceImpl.delete(clientId));
    }

}
