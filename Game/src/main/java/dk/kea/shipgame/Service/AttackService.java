package dk.kea.shipgame.Service;

import dk.kea.shipgame.Model.Order;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Repository.AttackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AttackService
{
    @Autowired
    AttackRepo attackRepo;

    public void resolveAttackOwn(List<Ship> ships, List<Order> orders)
    {
        attackRepo.resolveAttackOwn(ships, orders);
    }
    public void evaluateVictoryConditions(List<Ship> ships, List<Order> orders)
    {
        attackRepo.evaluateVictoryConditions(ships, orders);
    }
}
