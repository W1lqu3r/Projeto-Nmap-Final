package com.manager.ips.Repository;

import com.manager.ips.Model.Ip;
import com.manager.ips.Model.Port;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortRepository extends JpaRepository<Port,Integer> {


    List<Port> findByIpId(int ipId);
}
