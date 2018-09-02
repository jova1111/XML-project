package com.otkudznam.booking.repository;

import com.otkudznam.booking.model.Message;
import com.otkudznam.booking.model.UserType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
    List<Message> findByReceiverIdAndReceivingUserType(Long receiverId, UserType receivingUserType);

    List<Message> findBySenderIdAndSendingUserType(Long senderId, UserType sendingUserType);
}
