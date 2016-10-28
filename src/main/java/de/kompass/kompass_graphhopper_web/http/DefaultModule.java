package de.kompass.kompass_graphhopper_web.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.graphhopper.GraphHopper;
import com.graphhopper.util.CmdArgs;

import de.kompass.kompass_graphhopper.KompassGraphHopper;

public class DefaultModule extends com.graphhopper.http.DefaultModule {
    private final Logger logger = LoggerFactory.getLogger(getClass());

	public DefaultModule(CmdArgs args) {
		super(args);
	}

	@Override
	protected GraphHopper createGraphHopper(CmdArgs args) {
        GraphHopper tmp = new KompassGraphHopper().forServer().init(args);
        tmp.importOrLoad();
        logger.info("loaded graph at:" + tmp.getGraphHopperLocation()
                + ", source:" + tmp.getOSMFile()
                + ", flagEncoders:" + tmp.getEncodingManager()
                + ", class:" + tmp.getGraphHopperStorage().toDetailsString());
        return tmp;
	}
}
