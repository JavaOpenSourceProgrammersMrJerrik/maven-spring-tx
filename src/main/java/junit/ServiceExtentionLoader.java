package junit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceExtentionLoader {

	private static final Map<String,ServiceExtentionLoader> EXTENTION_LOADER_CONTAINER = new ConcurrentHashMap<String,ServiceExtentionLoader>();
	
	private String name;
	
	public static ServiceExtentionLoader getExtentionLoader(String name) {
		ServiceExtentionLoader loader = EXTENTION_LOADER_CONTAINER.get(name);
		if(null != loader){
			return loader;
		}
		EXTENTION_LOADER_CONTAINER.put(name, new ServiceExtentionLoader(name));
		return EXTENTION_LOADER_CONTAINER.get(name);
	}

	private ServiceExtentionLoader(String name) {
		this.name = name;
	}
	
	

	
}
