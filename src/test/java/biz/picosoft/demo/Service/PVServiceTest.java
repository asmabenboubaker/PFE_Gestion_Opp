package biz.picosoft.demo.Service;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.PV;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.PVRepository;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.PVDTO;
import biz.picosoft.demo.service.impl.ClientServiceImpl;
import biz.picosoft.demo.service.impl.PVServiceImpl;
import biz.picosoft.demo.service.mapper.ClientMapper;
import biz.picosoft.demo.service.mapper.PVMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PVServiceTest {
    @Mock
    private PVRepository pVRepository;

    @Mock
    private PVMapper pVMapper;

    @InjectMocks
    private PVServiceImpl pVServiceImpl;

    @Test
    public void CreatePV() {
        // Mocking dependencies
        PV pv = PV.builder()
                .contenu("pikachu")
                .participants("electric").build();
        PVDTO pvDto = PVDTO.builder()
                .contenu("pikachu")
                .participants("electric").build();

        when(pVMapper.toEntity(pvDto)).thenReturn(pv);
        when(pVMapper.toDto(pv)).thenReturn(pvDto);
        when(pVRepository.save(Mockito.any(PV.class))).thenReturn(pv);

        // Method under test
        PVDTO savedClient = pVServiceImpl.save(pvDto);

        // Assertion
        Assertions.assertThat(savedClient).isNotNull();
    }
    @Test
    public void FindById() {
        Long clientId = 1L;
        PVDTO client = PVDTO.builder().id(1L).contenu("pikachu")
                .participants("electric").build();
        //when(pVRepository.findById((long) clientId)).thenReturn(Optional.ofNullable(client));

        Optional<PVDTO> clientReturn = pVServiceImpl.findOne(clientId);

        Assertions.assertThat(clientReturn).isNotNull();
    }
}
