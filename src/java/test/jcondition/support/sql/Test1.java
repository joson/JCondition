package jcondition.support.sql;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import com.josonprog.common.expression.Constant;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;
import com.josonprog.common.expression.PropertyVariable;
import com.josonprog.common.expression.Variable;
import com.josonprog.jcondition.Condition;
import com.josonprog.jcondition.OperationUnsupportedException;
import com.josonprog.jcondition.support.sql.SqlInterpreter;

public class Test1 {
	
	public School getSchoolSample() {
		School school = new School();
		
		school.setName("MIT");
		school.setCreateDate(DateUtils.setYears(new Date(), 1861));
		System.out.println(school.getCreateDate());
		school.setAddress("Boston");
		school.setStudentAmount(30000);
		school.setScore(9.8f);
		
		
		return school;
	}
	
	public void test() {
		School school = this.getSchoolSample();
		
		Variable sch = new Variable(School.class, "sch");
		
		PropertyVariable score;
		try {
			score = new PropertyVariable(sch, "score");
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		Constant threhold = new Constant(8.5);
		
		Operand[] operands1 = new Operand[2];
		operands1[0] = score;
		operands1[1] = threhold;
		

		PropertyVariable addr;
		try {
			addr = new PropertyVariable(sch, "address");
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		Constant city = new Constant("Boston");
		
		Operand[] operands2 = new Operand[2];
		operands2[0] = addr;
		operands2[1] = city;
		
		

		Condition condition = new Condition(Operator.LT, operands1);
		//condition.and(Operator.LT, operands1);
		condition.not();
		condition.and(Operator.LIKE, operands2);
		
		SqlInterpreter interpreter = new SqlInterpreter();
		String sql;
		try {
			sql = interpreter.interpret(condition);
		} catch (OperationUnsupportedException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println(sql);
		
		
	}

	public static void main(String[] args) {
		Test1 test = new Test1();
		
		test.test();
	}

}
