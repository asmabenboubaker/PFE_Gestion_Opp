package biz.picosoft.demo.Service;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.ProjetRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.ProjetDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.impl.ProjetServiceImpl;
import biz.picosoft.demo.service.mapper.ClientMapper;
import biz.picosoft.demo.service.mapper.ProjetMapper;
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
public class ProjetServiceTest {

    @Mock
    private ProjetRepository projetRepository;

    @Mock
    private ProjetMapper projetMapper;

    @InjectMocks
    private ProjetServiceImpl projetService;


    @Test
    public void CreateProjet() {
        // Mocking dependencies
        Projet projet = Projet.builder()
                .nom("pikachu")
                .commentaires("electric").build();
        ProjetDTO projetDTO = ProjetDTO.builder()
                .nom("pikachu")
                .description("electric").build();

        when(projetMapper.toEntity(projetDTO)).thenReturn(projet);
        when(projetMapper.toDto(projet)).thenReturn(projetDTO);
        when(projetRepository.save(Mockito.any(Projet.class))).thenReturn(projet);

        // Method under test
        ProjetDTO savedClient = projetService.save(projetDTO);

        // Assertion
        Assertions.assertThat(savedClient).isNotNull();
    }

    @Test
    public void FindById() {
        Long projetId = 1L;
        Projet client = Projet.builder().id(1L).nom("pikachu").commentaires("electric").build();
        when(projetRepository.findById((long) projetId)).thenReturn(Optional.ofNullable(client));

        Optional<ProjetDTO> clientReturn = projetService.findOne(projetId);

        Assertions.assertThat(clientReturn).isNotNull();
    }
    @Test
    public void UpdateClient() {
        // Arrange
        Long projetId = 1L;
        Projet projet = Projet.builder().id(1L).nom("pikachu").commentaires("electric").build();
        ProjetDTO projetDTO = ProjetDTO.builder().id(projetId).nom("pikachu").commentaires("electric").build();

        // Mocking repository methods
        when(projetRepository.findById(projetId)).thenReturn(Optional.of(projet));
        when(projetRepository.save(projet)).thenReturn(projet);

        // Mocking the mapping from DTO to entity and back
        when(projetMapper.toEntity(projetDTO)).thenReturn(projet);
        when(projetMapper.toDto(projet)).thenReturn(projetDTO);

        // Act
        ProjetDTO updateReturn = projetService.update(projetDTO);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getNom()).isEqualTo("pikachu");
    }
    @Test
    public void DeleteById() {
        Long projetId = 1L;
        Projet projet = Projet.builder().id(1L).nom("pikachu").commentaires("electric").build();

        when(projetRepository.findById(projetId)).thenReturn(Optional.ofNullable(projet));
        doNothing().when(projetRepository).delete(projet);

        assertAll(() -> projetService.delete(projetId));
    }
}
