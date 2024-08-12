package biz.picosoft.demo.Repository;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    @Test
    public void testFindAll() {
        //kArrange
        Client client = Client.builder()
                .nom("pikachu")
                .adresse("electric").build();

        //Act
        Client savedClient = clientRepository.save(client);

        //Assert
        Assertions.assertThat(savedClient).isNotNull();
        Assertions.assertThat(savedClient.getId()).isGreaterThan(0);
    }
//    @Test
//    public void testFindById() {
//        //Arrange
//        Client client = Client.builder()
//                .nom("pikachu")
//                .adresse("electric").build();
//        Client savedClient = clientRepository.save(client);
//
//        //Act
//        Client foundClient = clientRepository.findById(savedClient.getId()).get();
//
//        //Assert
//        Assertions.assertThat(foundClient).isNotNull();
//        Assertions.assertThat(foundClient.getId()).isEqualTo(savedClient.getId());
//    }
//    //GetAll
//    @Test
//    public void testFindAllClients() {
//        //Arrange
//        Client client1 = Client.builder()
//                .nom("pikachu")
//                .adresse("electric").build();
//        Client client2 = Client.builder()
//                .nom("bulbasaur")
//                .adresse("grass").build();
//        clientRepository.save(client1);
//        clientRepository.save(client2);
//
//        //Act
//        Iterable<Client> clients = clientRepository.findAll();
//
//        //Assert
//        Assertions.assertThat(clients).isNotNull();
//        Assertions.assertThat(clients).hasSize(2);
//    }
//    //updateClient
//    @Test
//    public void testUpdateClient() {
//        //Arrange
//        Client client = Client.builder()
//                .nom("pikachu")
//                .adresse("electric").build();
//        Client savedClient = clientRepository.save(client);
//
//        //Act
//        savedClient.setNom("bulbasaur");
//        Client updatedClient = clientRepository.save(savedClient);
//
//        //Assert
//        Assertions.assertThat(updatedClient).isNotNull();
//        Assertions.assertThat(updatedClient.getId()).isEqualTo(savedClient.getId());
//        Assertions.assertThat(updatedClient.getNom()).isEqualTo("bulbasaur");
//    }
//    //delete client
//    @Test
//    public void testDeleteClient() {
//        //Arrange
//        Client client = Client.builder()
//                .nom("pikachu")
//                .adresse("electric").build();
//        Client savedClient = clientRepository.save(client);
//
//        //Act
//        clientRepository.deleteById(savedClient.getId());
//
//        //Assert
//        Assertions.assertThat(clientRepository.existsById(savedClient
//                .getId())).isFalse();
//
//    }

}
