function oxRendering() {
    $("#form-box").html(`
    <main className="content-area">
        <div className="quiz-frame">
            <div className="quiz-area">
                <p className="quiz-title">광복절은 1945년이다.</p>
                <div className="ox-area">
                    <span className="ox-radio">
                        <input type="radio" className="radio-form" id="chk-o" name="chk-ox"/>
                        <label htmlFor="chk-o" className="radio-label-o">
                            <i className="ic-o"></i>
                            <span className="for-a11y">O</span>
                            <span className="desc">설명 노출</span>
                        </label>
                    </span>
                    <span className="ox-radio">
                        <input type="radio" className="radio-form" id="chk-x" name="chk-ox"/>
                        <label htmlFor="chk-x" className="radio-label-x">
                            <i className="ic-x"></i>
                            <span className="for-a11y">X</span>
                            <span className="desc">설명 노출</span>
                        </label>
                    </span>
                </div>
                <div className="quiz-btn">
                    <button type="button" className="btn-type-dark">
                        <span className="btn-txt">정답확인</span>
                    </button>
                </div>
            </div>
        </div>
    </main>
    `);
}