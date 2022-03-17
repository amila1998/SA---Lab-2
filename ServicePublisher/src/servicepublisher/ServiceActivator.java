package servicepublisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public class ServiceActivator implements BundleActivator, ServiceListener {

	
	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Publisher Start");
		ServicePublish publisherService = new ServicePublisherImpi();  
		publishServiceRegistration = context.registerService(ServicePublish.class.getName(),publisherService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Publisher Stop");
		publishServiceRegistration.unregister();
		
	}

}
