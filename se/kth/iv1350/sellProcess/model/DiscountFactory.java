
package se.kth.iv1350.sellProcess.model;

public class DiscountFactory(DiscountFactoryEnum type) {
    return switch(type) {
        case MEMBER_DISCOUNT -> {
          
        }
        case NO_DISCOUNT -> {

            return new DiscountNone;
        }

        case TOTAL_PRICE_DISCOUNT -> {

        }

        case MEMBERSHIP_DISCOUNT -> {
            
        }
    };
}


            case NO_POS_INT -> {
              
              yield info + " är ett ogiltigt antal. Vänlig korrigera varuantalet.";

            }
            case ID_NOT_FOUND -> {
              String itemID = (String) info;
              yield "Varukoden" + "\"" + itemID + "\" finns inte i databasen. Varan är ej registrerad. ";
            }
            
        };

      }
}