package biz.picosoft.demo.Service;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.mapper.ClientMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientServiceImpl clientServiceImpl;

    @Test
    public void CreateClient() {
        // Mocking dependencies
        Client client = Client.builder()
                .nom("nom")
                .adresse("adresse").build();
        ClientDTO clientDto = ClientDTO.builder()
                .nom("nom")
                .adresse("adresse").build();

        when(clientMapper.toEntity(clientDto)).thenReturn(client);
        when(clientMapper.toDto(client)).thenReturn(clientDto);
        when(clientRepository.save(Mockito.any(Client.class)))
                .thenReturn(client);

        // Method under test
        ClientDTO savedClient = clientServiceImpl.save(clientDto);

        // Assertion
        Assertions.assertThat(savedClient).isNotNull();
    }
    //getallclients

//    @Test
//    public void GetAllClient() {
//        // Mocking dependencies
//        Client client1 = Client.builder()
//                .nom("pikachu")
//                .adresse("electric").build();
//        Client client2 = Client.builder()
//                .nom("bulbasaur")
//                .adresse("grass").build();
//        ClientDTO clientDto1 = ClientDTO.builder()
//                .nom("pikachu")
//                .adresse("electric").build();
//        ClientDTO clientDto2 = ClientDTO.builder()
//                .nom("bulbasaur")
//                .adresse("grass").build();
//
//        // Mock Pageable
//        Pageable pageable = (Pageable) PageRequest.of(0, 10);
//
//        // Create a Page object with the mock clients
//        Page<Client> page = new PageImpl<>(Arrays.asList(client1, client2));
//
//        // Mock the behavior of clientRepository and clientMapper
//        when(clientRepository.findAll((Sort) pageable)).thenReturn((List<Client>) page);
//        when(clientMapper.toDto(client1)).thenReturn(clientDto1);
//        when(clientMapper.toDto(client2)).thenReturn(clientDto2);
//
//        // Method under test
//        Page<ClientDTO> clientsPage = clientServiceImpl.findAll((org.springframework.data.domain.Pageable) pageable);
//        List<ClientDTO> clients = clientsPage.getContent();
//
//        // Assertions
//        Assertions.assertThat(clients).isNotNull();
//        Assertions.assertThat(clients.size()).isEqualTo(2);
//        Assertions.assertThat(clients.get(0).getNom()).isEqualTo("pikachu");
//        Assertions.assertThat(clients.get(1).getNom()).isEqualTo("bulbasaur");
//    }


    @Test
    public void FindById() {
        Long clientId = 1L;
        Client client = Client.builder().id(1L).nom("pikachu").adresse("electric").typeClient("this is a type").build();
        when(clientRepository.findById((long) clientId)).thenReturn(Optional.ofNullable(client));

        Optional<ClientDTO> clientReturn = clientServiceImpl.findOne(clientId);

        Assertions.assertThat(clientReturn).isNotNull();
    }
    @Test
    public void UpdateClient() {
        // Arrange
        Long clientId = 1L;
        Client client = Client.builder().id(clientId).nom("pikachu").adresse("electric").typeClient("this is a type").build();
        ClientDTO clientIdDto = ClientDTO.builder().id(clientId).nom("pikachu").adresse("electric").typeClient("this is a type").build();

        // Mocking repository methods
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));
        when(clientRepository.save(client)).thenReturn(client);

        // Mocking the mapping from DTO to entity and back
        when(clientMapper.toEntity(clientIdDto)).thenReturn(client);
        when(clientMapper.toDto(client)).thenReturn(clientIdDto);

        // Act
        ClientDTO updateReturn = clientServiceImpl.update(clientIdDto, clientId);

        // Assert
        Assertions.assertThat(updateReturn).isNotNull();
        Assertions.assertThat(updateReturn.getNom()).isEqualTo("pikachu");
    }
    @Test
    public void DeleteById() {
        Long clientId = 1L;
        Client client = Client.builder().id(1L).nom("pikachu").adresse("electric").typeClient("this is a type").build();

        when(clientRepository.findById(clientId)).thenReturn(Optional.ofNullable(client));
        doNothing().when(clientRepository).delete(client);

        assertAll(() -> clientServiceImpl.delete(clientId));
    }
}