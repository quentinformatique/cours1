$(document).on('DOMContentLoaded', () => {
    const TIMELINE = new gsap.timeline({paused: false,}),
        $HEADER = $('h1'),
        $ELEMENTS = $('.element'),
        $BUTTON = $('.btn-back'),
        $HR = $('hr')
        $FOOTER = $('footer');

    TIMELINE.from($HEADER, {
        duration: 1.5,
        y: 300,
        opacity: 0,
        ease: 'power4.out',
    }).from($BUTTON, {
        duration: 0.5,
        y: -100,
        opacity: 0,
        ease: 'power4.out',
    }).from($ELEMENTS, {
        duration: 2,
        y: 300,
        opacity: 0,
        ease: 'power4.out',
        stagger: 0.2,
    }).from($HR, {
        duration: 1,
        width: 0,
        ease: 'power4.out',
    }, "-=1.5")
    .from($FOOTER, {
        duration: 1,
        y: 300,
        opacity: 0,      
    }, "-=2.5");

    
});