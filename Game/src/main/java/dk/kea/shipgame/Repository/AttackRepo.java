package dk.kea.shipgame.Repository;

import dk.kea.shipgame.Model.Coordinate;
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
        for (Order order : orders)
        {
            for (Order o1 : orders)
            {
                for (Coordinate coordinate : o1.getCoordinateList())
                {
                    if (order.getTarget().getX() == coordinate.getX() && order.getTarget().getY() == coordinate.getY())
                    {
                        System.out.println("Hit");

                    } else {
                        System.out.println("gucci");
                    }
                }
            }

        }

    }

    @Override
    public void evaluateVictoryConditions(List<Ship> ships, List<Order> orders)
    {

    }
}
