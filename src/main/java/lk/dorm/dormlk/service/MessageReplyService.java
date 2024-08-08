package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.MessageReply;

public interface MessageReplyService {
    MessageReply createReply(Long messageId, String reply, Long id);
}
