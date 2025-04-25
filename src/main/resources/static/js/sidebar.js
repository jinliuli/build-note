<!-- 사이드바 열고 닫는 JavaScript -->

// 사이드바 토글 함수
function toggleSidebar() {
    document.getElementById('overlay').classList.toggle('show');
    document.getElementById('sidebar').classList.toggle('open');
    document.getElementById('menuIcon').classList.toggle('active');
}

// 사이드바만 닫기
function closeSidebar() {
    document.getElementById('overlay').classList.remove('show');
    document.getElementById('sidebar').classList.remove('open');
    document.getElementById('menuIcon').classList.remove('active');
}