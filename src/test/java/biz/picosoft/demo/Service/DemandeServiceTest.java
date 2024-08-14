package biz.picosoft.demo.Service;


import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.repository.DemandeRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.impl.DemandeServiceImpl;
import biz.picosoft.demo.service.mapper.DemandeMapper;
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
public class DemandeServiceTest {
    @Mock
    private DemandeRepository demandeRepository;

    @Mock
    private DemandeMapper demandeMapper;

    @InjectMocks
    private DemandeServiceImpl demandeServiceImpl;
    @Test
    public void CreateClient() {
        // Mocking dependencies
        Demande demande = Demande.builder()
                .nom("pikachu")
                .commentaires("electric").build();
        DemandeDTO demandeDto = DemandeDTO.builder()
                .nom("pikachu")
                .commentaires("electric").build();

        when(demandeMapper.toEntity(demandeDto)).thenReturn(demande);
        when(demandeMapper.toDto(demande)).thenReturn(demandeDto);
        when(demandeRepository.save(Mockito.any(Demande.class))).thenReturn(demande);

        // Method under test
        DemandeDTO saveddemande = demandeServiceImpl.save(demandeDto);

        // Assertion
        Assertions.assertThat(saveddemande).isNotNull();
    }
    @Test
    public void FindById() {
        Long demandeId = 1L;
        Demande demande = Demande.builder().id(1L).nom("pikachu").commentaires("electric").description("this is a descr").build();
        when(demandeRepository.findById((long) demandeId)).thenReturn(Optional.ofNullable(demande));

        Optional<DemandeDTO> demandeReturn = demandeServiceImpl.findOne(demandeId);

        Assertions.assertThat(demandeReturn).isNotNull();
    }
    @Test
    public void UpdateClient() {
        // Arrange
        Long demandeId = 1L;
        Demande demande = Demande.builder().id(demandeId).nom("pikachu").commentaires("electric").description("this is a descri").build();
        DemandeDTO demandeDto = DemandeDTO.builder().id(demandeId).nom("pikachu").commentaires("electric").description("this is a descri").build();

        // Mocking repository methods
        when(demandeRepository.findById(demandeId)).thenReturn(Optional.of(demande));
        when(demandeRepository.save(demande)).thenReturn(demande);

        // Mocking the mapping from DTO to entity and back
        when(demandeMapper.toEntity(demandeDto)).thenReturn(demande);
        when(demandeMapper.toDto(demande)).thenReturn(demandeDto);

        // Act
        DemandeDTO updateReturn = demandeServiceImpl.update(demandeDto);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getNom()).isEqualTo("pikachu");
    }
    @Test
    public void DeleteDemandeById() {
        Long demandeId = 1L;
        Demande demande = Demande.builder().id(1L).nom("pikachu").commentaires("electric").description("this is a type").build();

        when(demandeRepository.findById(demandeId)).thenReturn(Optional.ofNullable(demande));
        doNothing().when(demandeRepository).delete(demande);

        assertAll(() -> demandeServiceImpl.delete(demandeId));
    }
}
