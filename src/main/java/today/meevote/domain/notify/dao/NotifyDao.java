package today.meevote.domain.notify.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import today.meevote.domain.notify.dto.GetNotifyListDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NotifyDao {
    public int getUnreadNotifyCount(String email);

    public List<GetNotifyListDto> getNotifyList(String email);

    public void updateIsRead(@Param("notifyId") long notifyId, @Param("isRead") boolean isRead);

    public boolean isExistNotify(long notifyId, String email);

    public Optional<String> getEmailByNotifyId(long notifyId);

    public void createAllInviteNotify(long scheduleId);

    public void createAllConfirmNotify(long scheduleId);

    public void updateAllIsRead(String email, boolean isRead);
}
