package biz.picosoft.demo.Service;


import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.EquipeRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.EquipeDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.impl.EquipeServiceImp;
import biz.picosoft.demo.service.mapper.ClientMapper;
import biz.picosoft.demo.service.mapper.EquipeMapper;
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
public class EquipeServiceTest {
    @Mock
    private EquipeRepository equipeRepository;

    @Mock
    private EquipeMapper equipeMapper;

    @InjectMocks
    private EquipeServiceImp equipeServiceImp;


    @Test
    public void CreateEquipe() {
        // Mocking dependencies
        Equipe equipe = Equipe.builder()
                .nom("pikachu")
                .description("electric").build();
        EquipeDTO equipeDTO = EquipeDTO.builder()
                .nom("pikachu")
                .description("electric").build();

        when(equipeMapper.toEntity(equipeDTO)).thenReturn(equipe);
        when(equipeMapper.toDto(equipe)).thenReturn(equipeDTO);
        when(equipeRepository.save(Mockito.any(Equipe.class))).thenReturn(equipe);

        // Method under test
        Equipe savedClient = equipeServiceImp.createEquipe(equipe);

        // Assertion
        Assertions.assertThat(savedClient).isNotNull();
    }

    @Test
    public void FindById() {
        Long equipeId = 1L;
        Equipe equipe = Equipe.builder().id(1L).nom("pikachu").description("electric").email("this is an email").build();
        when(equipeRepository.findById((long) equipeId)).thenReturn(Optional.ofNullable(equipe));

        Equipe equipeReturn = equipeServiceImp.getEquipeById(equipeId);

        Assertions.assertThat(equipeReturn).isNotNull();
    }

    @Test
    public void UpdateEquipe() {
        // Arrange
        Long equipeId = 1L;
        Equipe equipe = Equipe.builder().id(equipeId).nom("pikachu").description("electric").email("this is an email").build();
        EquipeDTO equipeDTO = EquipeDTO.builder().id(equipeId).nom("pikachu").description("electric").email("this is an email").build();

        // Mocking repository methods
        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(equipe));
        when(equipeRepository.save(equipe)).thenReturn(equipe);

        // Mocking the mapping from DTO to entity and back
        when(equipeMapper.toEntity(equipeDTO)).thenReturn(equipe);
        when(equipeMapper.toDto(equipe)).thenReturn(equipeDTO);

        // Act
        Equipe updateReturn = equipeServiceImp.updateEquipe(equipeId,equipe);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getNom()).isEqualTo("pikachu");
    }
    @Test
    public void DeleteById() {
        Long equipeId = 1L;
        Equipe client = Equipe.builder().id(1L).nom("pikachu").description("electric").email("this is an email").build();

        when(equipeRepository.findById(equipeId)).thenReturn(Optional.ofNullable(client));
        doNothing().when(equipeRepository).delete(client);

        assertAll(() -> equipeServiceImp.deleteEquipe(equipeId));
    }
}
