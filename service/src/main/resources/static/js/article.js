const imagesPreview = document.createElement('div');
imagesPreview.classList.add('images-preview');

const imagesInput = document.getElementById('images');
imagesInput.parentNode.insertBefore(imagesPreview, imagesInput.nextSibling);

imagesInput.addEventListener('change', function() {
    imagesPreview.innerHTML = ''; // Clear previous preview
    for (let i = 0; i < this.files.length; i++) {
        const file = this.files[i];
        if (file.type.startsWith('image/')) {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function() {
                const img = document.createElement('img');
                img.src = reader.result;
                imagesPreview.appendChild(img);
            }
        }
    }
});


//
//
// const hashtagInput = document.getElementById('hashtag');
// hashtagInput.addEventListener('focus', addHashtagSymbol);
// hashtagInput.addEventListener('keyup', addHashtagSymbol);
//
// function addHashtagSymbol() {
//     if (!hashtagInput.value.startsWith('#')) {
//         hashtagInput.value = '#' + hashtagInput.value;
//     }
// }
//
//


const hashtagInput = document.getElementById('hashtag');
hashtagInput.addEventListener('focus', addHashtagSymbol);
hashtagInput.addEventListener('keydown', handleHashtagInput);

function addHashtagSymbol() {
    if (!hashtagInput.value.startsWith('#')) {
        hashtagInput.value = '#' + hashtagInput.value;
    }
}

function handleHashtagInput(event) {
    const message = hashtagInput.parentNode.querySelector('.error-message');
    if (event.keyCode === 32 || !isValidKey(event.key)) {
        if (!message) {
            const newMessage = document.createElement('div');
            newMessage.classList.add('error-message');
            newMessage.textContent = '해시태그는 컴마로 구분해주세요.';
            newMessage.style.color = 'red';
            hashtagInput.parentNode.append(newMessage, hashtagInput.nextSibling);
        }
        if (event.keyCode === 32) {
            hashtagInput.value += '#';
        }
        event.preventDefault();
    } else {
        if (message) {
            message.remove();
        }
    }
}

function isValidKey(key) {
    const allowedKeys = ['Backspace', 'Delete', 'ArrowLeft', 'ArrowRight', 'ArrowUp', 'ArrowDown', 'Control', 'Alt', 'Shift', 'CapsLock', 'Tab', 'Enter'];
    return /^[a-zA-Z0-9]+$/.test(key) || allowedKeys.includes(key);
}






// const hashtagInput = document.getElementById('hashtag');
// hashtagInput.addEventListener('focus', addHashtagSymbol);
// hashtagInput.addEventListener('keydown', handleHashtagInput);
//
// function addHashtagSymbol() {
//     if (!hashtagInput.value.startsWith('#')) {
//         hashtagInput.value = '#' + hashtagInput.value;
//     }
// }
//
// function handleHashtagInput(event) {
//     const message = hashtagInput.parentNode.querySelector('.error-message');
//     if (event.keyCode === 32 || !isValidKey(event.key)) {
//         if (!message) {
//             const newMessage = document.createElement('div');
//             newMessage.classList.add('error-message');
//             newMessage.textContent = '해시태그는 컴마로 구분해주세요.';
//             newMessage.style.color = 'red';
//             hashtagInput.parentNode.append(newMessage, hashtagInput.nextSibling);
//         }
//         event.preventDefault();
//     } else {
//         if (message) {
//             message.remove();
//         }
//     }
// }
//
// function isValidKey(key) {
//     const allowedKeys = ['Backspace', 'Delete', 'ArrowLeft', 'ArrowRight', 'ArrowUp', 'ArrowDown', 'Control', 'Alt', 'Shift', 'CapsLock', 'Tab', 'Enter'];
//     return /^[a-zA-Z0-9]+$/.test(key) || allowedKeys.includes(key);
// }






//




//
// const hashtagInput = document.getElementById('hashtag');
// hashtagInput.addEventListener('focus', addHashtagSymbol);
// hashtagInput.addEventListener('keyup', handleHashtagInput);
//
// function addHashtagSymbol() {
//     if (!hashtagInput.value.startsWith('#')) {
//         hashtagInput.value = '#' + hashtagInput.value;
//     }
// }
//
// function handleHashtagInput(event) {
//     const message = hashtagInput.parentNode.querySelector('.error-message');
//     if (event.keyCode === 32) { // Space key
//         if (!message) {
//             const newMessage = document.createElement('div');
//             newMessage.classList.add('error-message');
//             newMessage.textContent = '해시태그는 컴마로 구분해주세요.';
//             newMessage.style.color = 'red';
//             hashtagInput.parentNode.insertBefore(newMessage, hashtagInput.nextSibling);
//         }
//         hashtagInput.value = hashtagInput.value.trim();
//         event.preventDefault();
//     } else {
//         if (message) {
//             message.remove();
//         }
//     }
// }
//
//
// const hashtagInput = document.getElementById('hashtag');
// hashtagInput.addEventListener('focus', addHashtagSymbol);
// hashtagInput.addEventListener('keyup', handleHashtagInput);
//
// function addHashtagSymbol() {
//     if (!hashtagInput.value.startsWith('#')) {
//         hashtagInput.value = '#' + hashtagInput.value;
//     }
// }
//
// function handleHashtagInput(event) {
//     if (event.keyCode === 32) { // Space key
//         const message = document.createElement('div');
//         message.textContent = '해시태그는 컴마로 구분해주세요.';
//         message.style.color = 'red';
//         hashtagInput.parentNode.insertBefore(message, hashtagInput.nextSibling);
//         hashtagInput.value = hashtagInput.value.trim();
//         event.preventDefault();
//     }
// }
