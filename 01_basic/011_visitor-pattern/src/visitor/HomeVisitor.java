//https://blog.naver.com/2feelus/220664244510
	
package visitor;

public interface HomeVisitor {
	public void visit(CleanTask cleanTask);
	public void visit(CoolTask coolTask);
	public void visit(BabyCareTask babyCareTask);
}

public class ACompanyVisitor implements HomeVisitor {
	public void visit(CleanTask cleanTask) {
		
	};
	
	public void visit(CookTask cookTask){
		
	};

	public void visit(BabyCareTask babyCareTask){
		
	};	
}

public class BCompanyVisitor implements HomeVisitor {
	public void visit(CleanTask cleanTask) {
		
	};
	
	public void visit(CookTask cookTask){
		
	};

	public void visit(BabyCareTask babyCareTask){
		
	};
	
}

public interface HomeTaskElement {
	public void accept(HomeVisitor homeVisitor);
}

public interface HomeVisitor {

public void visit(CleanTask cleanTask);

public void visit(CookTask cookTask);

public void visit(BabyCareTask babyCareTask);

}

public class ACompanyVisitor implements HomeVisitor {

	public void visit(CleanTask cleanTask) {};
	
	public void visit(CookTask cookTask){  };
	
	public void visit(BabyCareTask babyCareTask){ };

} 

public class BCompanyVisitor implements HomeVisitor {

	public void visit(CleanTask cleanTask) { };
	
	public void visit(CookTask cookTask){  };
	
	public void visit(BabyCareTask babyCareTask){ };
}

public interface HomeTaskElement {
	public void accept(HomeVisitor homeVisitor);
}

public class CleanTask implements HomeTaskElement {

	public void accept(HomeVisitor homeVisitor) {
		homeVisitor.visit(this);

	}
}


public class CookTask implements HomeTaskElement {
	public void accept(HomeVisitor homeVisitor) {
		homeVisitor.visit(this);
	}
}

public class BabyCareTask implements HomeTaskElement {

	  public void accept(HomeVisitor homeVisitor) {

	    homeVisitor.visit(this);

	  }

	}


public class TotalHomeTask implements HomeTaskElement {

	  ArrayList homeTaskElements = new ArrayList<HomeTaskElement>();

	  public TotalHomeTask() {

	    homeTaskElements.add(new CleanTask());

	    homeTaskElements.add(new CookTask());

	    homeTaskElements.add(new BabyCareTask());

	  }

	  public void accept(HomeVisitor homeVisitor) {

	    Iterator it = homeTaskElements.iterator();

	    while(it.hasNext()) {

	      HomeTaskElement homeTaskElement = (HomeTaskElement )it.next();

	      homeTaskElement.accept(homeVisitor);

	    }

	  }

	}
	
	
public class HomeVisitorDemo  {

	  public static int main() {

	    TotalHomeTask totalHomeTask = new TotalHomeTask();

	    totalHomeTask.accept(new ACompanyVisitor());

	    totalHomeTask.accept(new BCompanyVisitor());

	  }

	}