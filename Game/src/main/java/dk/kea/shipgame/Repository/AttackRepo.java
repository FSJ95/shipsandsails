package dk.kea.shipgame.Repository;

import dk.kea.shipgame.Model.Order;
import dk.kea.shipgame.Model.Ship;
import dk.kea.shipgame.Service.IAttack;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttackRepo implements IAttack
{
    @Override
    public void resolveAttackOwn(List<Ship> ships, List<Order> orders)
    {


    }

    @Override
    public void evaluateVictoryConditions(List<Ship> ships, List<Order> orders)
    {

    }
}
