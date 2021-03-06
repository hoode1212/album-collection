import Songs from './Songs'
import Ratings from './Ratings'

export default function Album(album) {
    return `
        <h3 class="album__albumTitle title">Album: ${album.albumTitle}</h3>
        <image src="${album.image}">
        <p class="album__recordLabel">Record Label: ${album.recordLabel}</p>
        <p class="album__ratings">Rating: ${Ratings(album.ratings)}/5</p>
        <ul class="songs">
            <h3>Songs</h3>
            <li class="song">${Songs(album.songs)}</li>
        </ul>
        
            <section class="add__song">
                <input type="text" class="add__songTitle" placeholder="Song Title">
                <input type="text" class="add__duration" placeholder="Duration">
                <input type="text" class="add__link" placeholder="Link">
                <button class="add__song__button" id="${album.id}">Add Song</button>
            </section>

            <section class="add__rating">
                <input type="text" class="add__rating__value" placeholder="Rating">
                <button class="add__rating__button" id="${album.id}">Submit</button>
            </section>
            `
}