package com.itheima.b_di;

public class BookServiceImpl implements BookService {
	
	// ��ʽ1��֮ǰ���ӿ�=ʵ����
//	private BookDao bookDao = new BookDaoImpl();
	// ��ʽ2���ӿ� + setter
	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	public void addBook(){
		this.bookDao.save();
	}

	public BookServiceImpl() {
		System.out.println("��new ��");
	}
	
}
