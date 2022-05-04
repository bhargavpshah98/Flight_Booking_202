package design2;

import java.io.IOException;

public abstract class class1 {
    private class1 nextFilter;

    public class1(class1 nextFilter){
        this.nextFilter = nextFilter;
    }

    public boolean doFilter(dbGenerator dbGenerator) throws IOException {

        if (nextFilter == null) {
            // do something
            return validate(dbGenerator);
        } else {
            if (!validate(dbGenerator)) {
                return false;
            }
            nextFilter.doFilter(dbGenerator);
        }
        return true;
    }

    public abstract boolean validate(dbGenerator dbGenerator) throws IOException;
}
