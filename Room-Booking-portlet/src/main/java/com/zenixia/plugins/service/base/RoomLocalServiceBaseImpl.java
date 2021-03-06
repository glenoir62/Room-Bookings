package com.zenixia.plugins.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.zenixia.plugins.model.Room;
import com.zenixia.plugins.service.RoomLocalService;
import com.zenixia.plugins.service.persistence.EquipmentPersistence;
import com.zenixia.plugins.service.persistence.EquipmentTypePersistence;
import com.zenixia.plugins.service.persistence.RoomBookingPersistence;
import com.zenixia.plugins.service.persistence.RoomPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the room local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.zenixia.plugins.service.impl.RoomLocalServiceImpl}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.zenixia.plugins.service.impl.RoomLocalServiceImpl
 * @see com.zenixia.plugins.service.RoomLocalServiceUtil
 * @generated
 */
public abstract class RoomLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements RoomLocalService, IdentifiableBean {
    @BeanReference(type = com.zenixia.plugins.service.EquipmentLocalService.class)
    protected com.zenixia.plugins.service.EquipmentLocalService equipmentLocalService;
    @BeanReference(type = com.zenixia.plugins.service.EquipmentService.class)
    protected com.zenixia.plugins.service.EquipmentService equipmentService;
    @BeanReference(type = EquipmentPersistence.class)
    protected EquipmentPersistence equipmentPersistence;
    @BeanReference(type = com.zenixia.plugins.service.EquipmentTypeLocalService.class)
    protected com.zenixia.plugins.service.EquipmentTypeLocalService equipmentTypeLocalService;
    @BeanReference(type = com.zenixia.plugins.service.EquipmentTypeService.class)
    protected com.zenixia.plugins.service.EquipmentTypeService equipmentTypeService;
    @BeanReference(type = EquipmentTypePersistence.class)
    protected EquipmentTypePersistence equipmentTypePersistence;
    @BeanReference(type = com.zenixia.plugins.service.RoomLocalService.class)
    protected com.zenixia.plugins.service.RoomLocalService roomLocalService;
    @BeanReference(type = com.zenixia.plugins.service.RoomService.class)
    protected com.zenixia.plugins.service.RoomService roomService;
    @BeanReference(type = RoomPersistence.class)
    protected RoomPersistence roomPersistence;
    @BeanReference(type = com.zenixia.plugins.service.RoomBookingLocalService.class)
    protected com.zenixia.plugins.service.RoomBookingLocalService roomBookingLocalService;
    @BeanReference(type = com.zenixia.plugins.service.RoomBookingService.class)
    protected com.zenixia.plugins.service.RoomBookingService roomBookingService;
    @BeanReference(type = RoomBookingPersistence.class)
    protected RoomBookingPersistence roomBookingPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private RoomLocalServiceClpInvoker _clpInvoker = new RoomLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.zenixia.plugins.service.RoomLocalServiceUtil} to access the room local service.
     */

    /**
     * Adds the room to the database. Also notifies the appropriate model listeners.
     *
     * @param room the room
     * @return the room that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Room addRoom(Room room) throws SystemException {
        room.setNew(true);

        return roomPersistence.update(room);
    }

    /**
     * Creates a new room with the primary key. Does not add the room to the database.
     *
     * @param roomId the primary key for the new room
     * @return the new room
     */
    @Override
    public Room createRoom(long roomId) {
        return roomPersistence.create(roomId);
    }

    /**
     * Deletes the room with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param roomId the primary key of the room
     * @return the room that was removed
     * @throws PortalException if a room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     * @throws com.liferay.portal.security.auth.PrincipalException
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Room deleteRoom(long roomId)
        throws PortalException, SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return roomPersistence.remove(roomId);
    }

    /**
     * Deletes the room from the database. Also notifies the appropriate model listeners.
     *
     * @param room the room
     * @return the room that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Room deleteRoom(Room room) throws SystemException {
        return roomPersistence.remove(room);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Room.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return roomPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return roomPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return roomPersistence.findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return roomPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return roomPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Room fetchRoom(long roomId) throws SystemException {
        return roomPersistence.fetchByPrimaryKey(roomId);
    }

    /**
     * Returns the room with the matching UUID and company.
     *
     * @param uuid the room's UUID
     * @param  companyId the primary key of the company
     * @return the matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchRoomByUuidAndCompanyId(String uuid, long companyId)
        throws SystemException {
        return roomPersistence.fetchByUuid_C_First(uuid, companyId, null);
    }

    /**
     * Returns the room matching the UUID and group.
     *
     * @param uuid the room's UUID
     * @param groupId the primary key of the group
     * @return the matching room, or <code>null</code> if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room fetchRoomByUuidAndGroupId(String uuid, long groupId)
        throws SystemException {
        return roomPersistence.fetchByUUID_G(uuid, groupId);
    }

    /**
     * Returns the room with the primary key.
     *
     * @param roomId the primary key of the room
     * @return the room
     * @throws PortalException if a room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room getRoom(long roomId) throws PortalException, SystemException {
        return roomPersistence.findByPrimaryKey(roomId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return roomPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns the room with the matching UUID and company.
     *
     * @param uuid the room's UUID
     * @param  companyId the primary key of the company
     * @return the matching room
     * @throws PortalException if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room getRoomByUuidAndCompanyId(String uuid, long companyId)
        throws PortalException, SystemException {
        return roomPersistence.findByUuid_C_First(uuid, companyId, null);
    }

    /**
     * Returns the room matching the UUID and group.
     *
     * @param uuid the room's UUID
     * @param groupId the primary key of the group
     * @return the matching room
     * @throws PortalException if a matching room could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Room getRoomByUuidAndGroupId(String uuid, long groupId)
        throws PortalException, SystemException {
        return roomPersistence.findByUUID_G(uuid, groupId);
    }

    /**
     * Returns a range of all the rooms.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.model.impl.RoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of rooms
     * @param end the upper bound of the range of rooms (not inclusive)
     * @return the range of rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Room> getRooms(int start, int end) throws SystemException {
        return roomPersistence.findAll(start, end);
    }

    /**
     * Returns the number of rooms.
     *
     * @return the number of rooms
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getRoomsCount() throws SystemException {
        return roomPersistence.countAll();
    }

    /**
     * Updates the room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param room the room
     * @return the room that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Room updateRoom(Room room) throws SystemException {
        return roomPersistence.update(room);
    }

    /**
     * Returns the equipment local service.
     *
     * @return the equipment local service
     */
    public com.zenixia.plugins.service.EquipmentLocalService getEquipmentLocalService() {
        return equipmentLocalService;
    }

    /**
     * Sets the equipment local service.
     *
     * @param equipmentLocalService the equipment local service
     */
    public void setEquipmentLocalService(
        com.zenixia.plugins.service.EquipmentLocalService equipmentLocalService) {
        this.equipmentLocalService = equipmentLocalService;
    }

    /**
     * Returns the equipment remote service.
     *
     * @return the equipment remote service
     */
    public com.zenixia.plugins.service.EquipmentService getEquipmentService() {
        return equipmentService;
    }

    /**
     * Sets the equipment remote service.
     *
     * @param equipmentService the equipment remote service
     */
    public void setEquipmentService(
        com.zenixia.plugins.service.EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    /**
     * Returns the equipment persistence.
     *
     * @return the equipment persistence
     */
    public EquipmentPersistence getEquipmentPersistence() {
        return equipmentPersistence;
    }

    /**
     * Sets the equipment persistence.
     *
     * @param equipmentPersistence the equipment persistence
     */
    public void setEquipmentPersistence(
        EquipmentPersistence equipmentPersistence) {
        this.equipmentPersistence = equipmentPersistence;
    }

    /**
     * Returns the equipment type local service.
     *
     * @return the equipment type local service
     */
    public com.zenixia.plugins.service.EquipmentTypeLocalService getEquipmentTypeLocalService() {
        return equipmentTypeLocalService;
    }

    /**
     * Sets the equipment type local service.
     *
     * @param equipmentTypeLocalService the equipment type local service
     */
    public void setEquipmentTypeLocalService(
        com.zenixia.plugins.service.EquipmentTypeLocalService equipmentTypeLocalService) {
        this.equipmentTypeLocalService = equipmentTypeLocalService;
    }

    /**
     * Returns the equipment type remote service.
     *
     * @return the equipment type remote service
     */
    public com.zenixia.plugins.service.EquipmentTypeService getEquipmentTypeService() {
        return equipmentTypeService;
    }

    /**
     * Sets the equipment type remote service.
     *
     * @param equipmentTypeService the equipment type remote service
     */
    public void setEquipmentTypeService(
        com.zenixia.plugins.service.EquipmentTypeService equipmentTypeService) {
        this.equipmentTypeService = equipmentTypeService;
    }

    /**
     * Returns the equipment type persistence.
     *
     * @return the equipment type persistence
     */
    public EquipmentTypePersistence getEquipmentTypePersistence() {
        return equipmentTypePersistence;
    }

    /**
     * Sets the equipment type persistence.
     *
     * @param equipmentTypePersistence the equipment type persistence
     */
    public void setEquipmentTypePersistence(
        EquipmentTypePersistence equipmentTypePersistence) {
        this.equipmentTypePersistence = equipmentTypePersistence;
    }

    /**
     * Returns the room local service.
     *
     * @return the room local service
     */
    public com.zenixia.plugins.service.RoomLocalService getRoomLocalService() {
        return roomLocalService;
    }

    /**
     * Sets the room local service.
     *
     * @param roomLocalService the room local service
     */
    public void setRoomLocalService(
        com.zenixia.plugins.service.RoomLocalService roomLocalService) {
        this.roomLocalService = roomLocalService;
    }

    /**
     * Returns the room remote service.
     *
     * @return the room remote service
     */
    public com.zenixia.plugins.service.RoomService getRoomService() {
        return roomService;
    }

    /**
     * Sets the room remote service.
     *
     * @param roomService the room remote service
     */
    public void setRoomService(
        com.zenixia.plugins.service.RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * Returns the room persistence.
     *
     * @return the room persistence
     */
    public RoomPersistence getRoomPersistence() {
        return roomPersistence;
    }

    /**
     * Sets the room persistence.
     *
     * @param roomPersistence the room persistence
     */
    public void setRoomPersistence(RoomPersistence roomPersistence) {
        this.roomPersistence = roomPersistence;
    }

    /**
     * Returns the room booking local service.
     *
     * @return the room booking local service
     */
    public com.zenixia.plugins.service.RoomBookingLocalService getRoomBookingLocalService() {
        return roomBookingLocalService;
    }

    /**
     * Sets the room booking local service.
     *
     * @param roomBookingLocalService the room booking local service
     */
    public void setRoomBookingLocalService(
        com.zenixia.plugins.service.RoomBookingLocalService roomBookingLocalService) {
        this.roomBookingLocalService = roomBookingLocalService;
    }

    /**
     * Returns the room booking remote service.
     *
     * @return the room booking remote service
     */
    public com.zenixia.plugins.service.RoomBookingService getRoomBookingService() {
        return roomBookingService;
    }

    /**
     * Sets the room booking remote service.
     *
     * @param roomBookingService the room booking remote service
     */
    public void setRoomBookingService(
        com.zenixia.plugins.service.RoomBookingService roomBookingService) {
        this.roomBookingService = roomBookingService;
    }

    /**
     * Returns the room booking persistence.
     *
     * @return the room booking persistence
     */
    public RoomBookingPersistence getRoomBookingPersistence() {
        return roomBookingPersistence;
    }

    /**
     * Sets the room booking persistence.
     *
     * @param roomBookingPersistence the room booking persistence
     */
    public void setRoomBookingPersistence(
        RoomBookingPersistence roomBookingPersistence) {
        this.roomBookingPersistence = roomBookingPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.zenixia.plugins.model.Room",
            roomLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.zenixia.plugins.model.Room");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Room.class;
    }

    protected String getModelClassName() {
        return Room.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = roomPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
