import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessManageTest {
    @Test
    void basicAndBasicShouldReturnFalse() {
        AccessManage accessManage = new AccessManage();
        assertFalse(accessManage.checkAccess(AccessType.BASIC, AccessType.BASIC));
    }
    @Test
    void adminAndAdminShouldReturnFalse() {
        AccessManage accessManage = new AccessManage();
        assertFalse(accessManage.checkAccess(AccessType.ADMIN, AccessType.ADMIN));
    }
    @Test
    void ownerAndOwnerShouldReturnFalse() {
        AccessManage accessManage = new AccessManage();
        assertFalse(accessManage.checkAccess(AccessType.OWNER, AccessType.OWNER));
    }
    @Test
    void adminAndBasicShouldReturnTrue() {
        AccessManage accessManage = new AccessManage();
        assertTrue(accessManage.checkAccess(AccessType.ADMIN, AccessType.BASIC));
    }
    @Test
    void ownerAndBasicShouldReturnTrue() {
        AccessManage accessManage = new AccessManage();
        assertTrue(accessManage.checkAccess(AccessType.OWNER, AccessType.BASIC));
    }
    @Test
    void basicAndAdminShouldReturnFalse() {
        AccessManage accessManage = new AccessManage();
        assertFalse(accessManage.checkAccess(AccessType.BASIC, AccessType.ADMIN));
    }
    @Test
    void basicAndOwnerShouldReturnFalse() {
        AccessManage accessManage = new AccessManage();
        assertFalse(accessManage.checkAccess(AccessType.BASIC, AccessType.OWNER));
    }
    @Test
    void adminAndOwnerShouldReturnFalse() {
        AccessManage accessManage = new AccessManage();
        assertFalse(accessManage.checkAccess(AccessType.ADMIN, AccessType.OWNER));
    }
    @Test
    void ownerAndAdminShouldReturnTrue() {
        AccessManage accessManage = new AccessManage();
        assertTrue(accessManage.checkAccess(AccessType.OWNER, AccessType.ADMIN));
    }
    @Test
    void checkLogBasicShouldReturnTrue() {
        AccessManage accessManage = new AccessManage();
        assertTrue(accessManage.checkLogAccess(AccessType.BASIC));
    }
    @Test
    void checkLogAdminShouldReturnTrue() {
        AccessManage accessManage = new AccessManage();
        assertTrue(accessManage.checkLogAccess(AccessType.ADMIN));
    }
    @Test
    void checkLogOwnerShouldReturnTrue() {
        AccessManage accessManage = new AccessManage();
        assertTrue(accessManage.checkLogAccess(AccessType.OWNER));
    }
}