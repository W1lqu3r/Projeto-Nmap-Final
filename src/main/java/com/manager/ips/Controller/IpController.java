package com.manager.ips.Controller;


import com.manager.ips.Dto.IpDto;
import com.manager.ips.Dto.PortDto;
import com.manager.ips.Model.Ip;
import com.manager.ips.Model.Port;
import com.manager.ips.Repository.IpRepository;
import com.manager.ips.Repository.PortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IpController {

    private final IpRepository ipRepository;
    private final PortRepository portRepository;

   @GetMapping("/all-ports")
    public List<PortDto> portList(
            @RequestParam String ipName
    ){
        List<PortDto> portDtoList= new ArrayList<PortDto>();
       List<Port> portList = new ArrayList<Port>();
        Ip ip = ipRepository.findByIpValue(ipName);

        if(ip != null) {
           portList = portRepository.findByIpId(ip.getId());
        }

       for (Port port: portList) {
           PortDto portDto = new PortDto(port);
           portDtoList.add(portDto);
       }

       return portDtoList;
    }



    @GetMapping("/ports-by-status")
    public List<PortDto> usersList(
            @RequestParam String ipName,
            @RequestParam String active
    ){
        List<Port> portList = new ArrayList<Port>();
        List<PortDto> portDtoList= new ArrayList<PortDto>();
        Ip ip = ipRepository.findByIpValue(ipName);
        if(ip != null) {
            portList = portRepository.findByIpId(ip.getId());
        }


        for (Port port: portList) {
            PortDto portDto = new PortDto(port);
            if(port.isOpen() == Boolean.parseBoolean(active)){
                portDtoList.add(portDto);
            }
        }

        return portDtoList;
    }


    @GetMapping("/generate-ports")
    public void generatePort(){


        Ip ip1 = new Ip();
        ip1.setIpValue("10.20.30.40");
        ipRepository.save(ip1);

        for (int i=10; i<100; i+=10){
            Port port1 = new Port();
            port1.setPortValue(String.valueOf(i));
            port1.setOpen((i / 10) % 2 != 0);
            port1.setIp(ip1);
            portRepository.save(port1);
        }

        Ip ip2 = new Ip();
        ip2.setIpValue("55.66.77.88");
        ipRepository.save(ip2);

        for (int i=100; i<1000; i+=100){
            Port port2 = new Port();
            port2.setPortValue(String.valueOf(i));
            port2.setOpen((i / 100) % 2 != 0);
            port2.setIp(ip2);
            portRepository.save(port2);
        }


        Ip ip3 = new Ip();
        ip3.setIpValue("99.11.22.33");
        ipRepository.save(ip3);

        for (int i=1000; i<10000; i+=1000){
            Port port3 = new Port();
            port3.setPortValue(String.valueOf(i));
            port3.setOpen((i / 100) % 2 != 0);
            port3.setIp(ip3);
            portRepository.save(port3);
        }

        /*List<Port> portList3 = portRepository.findAllByIp(ip3);

        ip3.setPortsList(portList3);
        ipRepository.save(ip3);*/

    }
}
