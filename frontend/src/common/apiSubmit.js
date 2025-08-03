export async function apiSubmit(submitName, requestFunc, params, callbackObj = {}) {
    try {
        const response = await requestFunc(params);

        if (response.success) {
            const callbackName = `submit_${submitName}_callback`;
            if (callbackObj[callbackName]) {
                callbackObj[callbackName](response);
            } else {
                console.warn('콜백 함수 ${callbackName}가 정의되지 않았습니다.');
            }
        } else {
            const errorCallbackName = `submit_${submitName}_exception`;
            if (callbackObj[errorCallbackName]) {
                callbackObj[errorCallbackName](response);
            } else {
                alert(response.msg || '오류가 발생했습니다.');
            }
        }
    } catch (error) {
        console.error(error);
        const errorCallbackName = `submit_${submitName}_exception`;
        if (callbackObj[errorCallbackName]) {
            callbackObj[errorCallbackName]({ success: false, msg: '서버 오류가 발생했어요.' });
        } else {
            alert('오류가 발생했습니다: ');
        }
    }

}