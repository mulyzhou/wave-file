package top.itweek.wavefile.advice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import top.itweek.wavefile.contanst.CommonConst;
import top.itweek.wavefile.entity.ResponseVO;
import top.itweek.wavefile.enums.ResponseStatus;
import top.itweek.wavefile.exception.GlobalFileException;
import top.itweek.wavefile.exception.ZhydException;
import top.itweek.wavefile.holder.RequestHolder;
import top.itweek.wavefile.util.RequestUtil;
import top.itweek.wavefile.util.ResultUtil;

import java.lang.reflect.UndeclaredThrowableException;


@Slf4j
@ControllerAdvice
public class ExceptionHandleController {

    /**
     * Shiro权限认证异常
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(value = {UnauthorizedException.class, AccountException.class})
//    @ResponseBody
//    public ResponseVO unauthorizedExceptionHandle(Throwable e) {
//        e.printStackTrace(); // 打印异常栈
//        return ResultUtil.error(HttpStatus.UNAUTHORIZED.value(), e.getLocalizedMessage());
//    }

    /**
     * Shiro权限认证异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    @ResponseBody
    public ResponseVO maxUploadSizeExceededExceptionHandle(Throwable e) {
        e.printStackTrace(); // 打印异常栈
        return ResultUtil.error(CommonConst.DEFAULT_ERROR_CODE, ResponseStatus.UPLOAD_FILE_ERROR.getMessage() + "文件过大！");
    }

    /**
     * MethodArgumentTypeMismatchException ： 方法参数类型异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Object methodArgumentTypeMismatchException(Throwable e) {
        log.error("url参数异常，请检查参数类型是否匹配！", e);
        if (RequestUtil.isAjax(RequestHolder.getRequest())) {
            return ResultUtil.error(ResponseStatus.INVALID_PARAMS);
        }
        return ResultUtil.forward("/error/500");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVO handle(Throwable e) {
        if (e instanceof ZhydException || e instanceof GlobalFileException) {
            return ResultUtil.error(e.getMessage());
        }
        if (e instanceof UndeclaredThrowableException) {
            e = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
        }
        ResponseStatus responseStatus = ResponseStatus.getResponseStatus(e.getMessage());
        if (responseStatus != null) {
            log.error(responseStatus.getMessage());
            return ResultUtil.error(responseStatus.getCode(), responseStatus.getMessage());
        }
        e.printStackTrace(); // 打印异常栈
        return ResultUtil.error(CommonConst.DEFAULT_ERROR_CODE, ResponseStatus.ERROR.getMessage());
    }
}
