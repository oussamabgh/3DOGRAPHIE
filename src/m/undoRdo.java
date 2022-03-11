package m;

import javafx.scene.Group;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class undoRdo {
private int i;
private int j;
private Group list1[] = new Group[256];
private Group list2[] = new Group[256];
public void setList1(Group group) {
	list1[i]=group;
	i++;
	System.out.println("/////"+i);
}
public void setList2(Group group) {
	list2[j]=group;	
	j++;
}
public Group undo() {
	if (i==0) return list1[0];
	else
		{
		i--;
		System.out.println("/////"+i);
	return list1[i];
	}	
}
public Group redo() {	
	if (j==0) return list2[0];
	else
	{
		j--;
	return list2[j];
	}
}
public void decI() {
	i--;
}
public void decJ() {
	j--;
}
}
