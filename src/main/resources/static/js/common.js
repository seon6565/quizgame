async function copyLink(e){
    //보안적 이슈로 localhost나 https에서만 사용가능
    alert("링크가 복사되었습니다.");
    console.log(e);
    try {
        await navigator.clipboard.writeText(e);
    } catch (error) {
        console.error(error.message);
    }
}
