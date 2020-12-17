package org.tektutor;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Row;

public class BookMapper implements MapFunction<Row,Book> {

	private static final long serialVersionUID = -2L;

	@Override
	public Book call( Row value ) throws Exception {
		
		Book book = new Book();

		book.setId( value.getAs("id") );
		book.setAuthor ( value.getAs("author") );
		book.setTitle ( value.getAs("title") );

		return book;
	}

}
