package guru.qa.niffler.db.repository;

import guru.qa.niffler.db.model.UserAuthEntity;
import guru.qa.niffler.db.model.UserEntity;

import java.util.UUID;

public interface UserRepository {

  UserAuthEntity createInAuth(UserAuthEntity user);

  UserEntity createInUserdata(UserEntity user);

  void deleteInAuthById(UUID id);

  void deleteInUserdataById(UUID id);

  UserAuthEntity getFromAuthById(UUID id);

  UserEntity getFromUserdataById(UUID id);

  UserAuthEntity updateInAuth(UserAuthEntity user);

  UserEntity updateInUserdata(UserEntity user);
}
