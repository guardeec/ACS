package startpoint;

import steps.shutdown.endpoint;
import steps.initialization.initialisation;
import steps.run.work;

/**
 * Created by guardeec on 18.05.15.
 */
public class Main {
    public static void main(String args[]) {
        initialisation.start();
        work.start();
        endpoint.start();
    }

}

