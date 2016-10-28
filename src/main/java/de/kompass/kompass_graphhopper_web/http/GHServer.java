package de.kompass.kompass_graphhopper_web.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceFilter;
import com.graphhopper.http.GHServletModule;
import com.graphhopper.util.CmdArgs;

public class GHServer extends com.graphhopper.http.GHServer {

    public static void main( String[] args ) throws Exception
    {
        new GHServer(CmdArgs.read(args)).start();
    }
    
	private CmdArgs args;
    private final Logger logger = LoggerFactory.getLogger(getClass());

	public GHServer(CmdArgs args) {
		super(args);
		logger.info("Started!");
        this.args = args;
	}

	@Override
    protected Module createModule()
    {
        return new AbstractModule()
        {
            @Override
            protected void configure()
            {
                binder().requireExplicitBindings();

                install(new DefaultModule(args));
                install(new GHServletModule(args));

                bind(GuiceFilter.class);
            }
        };
    }
}
