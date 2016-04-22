//shoutout to G. Cope
package com.frc2367.data.teams;

import java.util.Collection;

public interface Searchable<E extends Comparable<? super E>> {
	
	public Collection<E> search(String string);

}