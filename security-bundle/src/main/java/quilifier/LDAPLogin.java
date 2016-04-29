package quilifier;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Created by ImadYamane on 29/04/16.
 */

@Qualifier
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER })
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LDAPLogin {
}
