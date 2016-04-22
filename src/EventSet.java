
public class EventSet {
	private Event[] events = new Event[100];
	private int index = 0;
	private int next = 0;
	public void add (Event e) {
		if(index >= events.length)
			return;
		if (index % 2 == 0)			
			events[index++] = e;
		else {
			if (events[index - 1].prioridade() <= e.prioridade()) {
				events[index++] = e;
			}
			else {
				events[index] = events[index - 1];
				events[index - 1] = e;
				index++;
			}
		}
	}
	public Event getNext() {
		//boolean looped = false;
		while(next < index) {
			if (events[next] != null)
				return events[next];
			next++;
		}
		return null;
		/*do {
			next = (next + 1) % events.length;
			//See if it has looped to the beginning:
			if (start == next) looped = true;
			// If it loops past start the list 
			// is empty	:
			if ((next == (start + 1) % events.length) && looped)
				return null;
		} while (events[next] == null);
		return events[next];*/
	}
	public void removeCurrent() {
		events[next] = null;
	}
	
}