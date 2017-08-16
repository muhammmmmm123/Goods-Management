/**
 * ��Ʒ�����ӿ�
 */

package com.njupt.mis.handler;

import java.util.Vector;

import com.njupt.mis.model.Goods;
import com.njupt.mis.model.StorageGoods;

public interface GoodsServicesHandler
{
	
	/**
	 * �����ݿ�����������Ʒ
	 * @param goods  ��װ�õ�goods����
	 * @return  ִ�н��
	 */
	boolean addGoods(Goods goods);
	/**
	 * �����ݿ���ɾ����Ʒ
	 * @param id  ��ɾ����Ʒ�ı��
	 * @return  ִ�н��
	 */
	boolean deleteGoods(String id);
	/**
	 * ��ѯ���ݿ���������������Ʒ
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	Vector<Goods> searchGoods(String field,String value);
	/**
	 * �޸���Ʒ�ļ۸�
	 * @param id ���޸ĵ���Ʒ���
	 * @param price �µļ۸�
	 * @return ִ�н��
	 */
	boolean modifyGoodsPrice(String id,double price);
	/**
	 * ��ȡ���е���Ʒ
	 * @return ��Ʒ�ļ���
	 */
	Vector<Goods> getAllGoods();
	/**
     * �ж���Ʒ�Ƿ����
     * @param id ��ѯ����Ʒ���
     * @return ��ѯ���
     */
    boolean isExited(String id);
    /**
     * ��ȡ��Ʒ����Ϣ
     * @param id ����ѯ����Ʒ�ı��
     * @return ��ѯ���
     */
    Goods getGoodsInfo(String id);
    /**
	 * ��ѯ������Ʒ��Ϣ
	 * @return  ��ѯ�����
	 */
	Vector<StorageGoods> getAllStorageGoods();
}