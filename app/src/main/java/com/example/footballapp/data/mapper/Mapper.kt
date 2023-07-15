package com.example.footballapp.data.mapper

import com.example.footballapp.data.model.chempionship.detail_team.DetailTeamResponse
import com.example.footballapp.data.model.chempionship.detail_team.CoachResponse
import com.example.footballapp.data.model.chempionship.detail_team.ContractResponse
import com.example.footballapp.data.model.chempionship.detail_team.RunningCompetitionResponse
import com.example.footballapp.data.model.chempionship.detail_team.SquadResponse
import com.example.footballapp.data.model.chempionship.matches.AreaResponse
import com.example.footballapp.data.model.chempionship.matches.AwayTeamResponse
import com.example.footballapp.data.model.chempionship.matches.CompetitionResponse
import com.example.footballapp.data.model.chempionship.matches.ExtraTimeResponse
import com.example.footballapp.data.model.chempionship.matches.FiltersResponse
import com.example.footballapp.data.model.chempionship.matches.FullTimeResponse
import com.example.footballapp.data.model.chempionship.matches.HalfTimeResponse
import com.example.footballapp.data.model.chempionship.matches.HomeTeamResponse
import com.example.footballapp.data.model.chempionship.matches.MatchesModelResponse
import com.example.footballapp.data.model.chempionship.matches.MatchesResponse
import com.example.footballapp.data.model.chempionship.matches.OddsResponse
import com.example.footballapp.data.model.chempionship.matches.PenaltiesResponse
import com.example.footballapp.data.model.chempionship.matches.RefereeResponse
import com.example.footballapp.data.model.chempionship.matches.RegularTimeResponse
import com.example.footballapp.data.model.chempionship.matches.ResultSetResponse
import com.example.footballapp.data.model.chempionship.matches.ScoreResponse
import com.example.footballapp.data.model.chempionship.matches.SeasonResponse
import com.example.footballapp.data.model.chempionship.matches_team.FiltersTeamMatchesResponse
import com.example.footballapp.data.model.chempionship.matches_team.ResultSetTeamMatchesResponse
import com.example.footballapp.data.model.chempionship.matches_team.TeamMatchesResponse
import com.example.footballapp.data.model.chempionship.scores.FiltersScorersResponse
import com.example.footballapp.data.model.chempionship.scores.PlayerResponse
import com.example.footballapp.data.model.chempionship.scores.ScorerResponse
import com.example.footballapp.data.model.chempionship.scores.ScorersResponse
import com.example.footballapp.data.model.chempionship.scores.TeamResponse
import com.example.footballapp.domain.model.detail_team.AreaModel
import com.example.footballapp.domain.model.detail_team.TeamDetailModel
import com.example.footballapp.domain.model.detail_team.Coach
import com.example.footballapp.domain.model.detail_team.Contract
import com.example.footballapp.domain.model.detail_team.RunningCompetition
import com.example.footballapp.domain.model.detail_team.Squad
import com.example.footballapp.domain.model.matches.CompetitionModel
import com.example.footballapp.domain.model.matches.FiltersModel
import com.example.footballapp.domain.model.matches.Matches
import com.example.footballapp.domain.model.matches.MatchesModel
import com.example.footballapp.domain.model.matches.OddsModel
import com.example.footballapp.domain.model.matches.RefereeModel
import com.example.footballapp.domain.model.matches.ResultSetModel
import com.example.footballapp.domain.model.matches.ScoreModel
import com.example.footballapp.domain.model.matches.SeasonModel
import com.example.footballapp.domain.model.matches.TeamModel
import com.example.footballapp.domain.model.matches.TimeModel
import com.example.footballapp.domain.model.scorers.FiltersScorersModel
import com.example.footballapp.domain.model.scorers.PlayerModel
import com.example.footballapp.domain.model.scorers.ScorerModel
import com.example.footballapp.domain.model.scorers.ScorersModel
import com.example.footballapp.domain.model.scorers.TeamScorersModel
import com.example.footballapp.domain.model.team_matches.FiltersTeamMatchesModel
import com.example.footballapp.domain.model.team_matches.ResultSetTeamMatchesModel
import com.example.footballapp.domain.model.team_matches.TeamMatchesModel

// TODO: Детальный экран команды
fun DetailTeamResponse.toDomainTeamDetail(): TeamDetailModel = TeamDetailModel(
    address = address,
    area = area.toDomain(),
    clubColors = clubColors,
    coach = coach.toDomain(),
    crest = crest,
    founded = founded,
    id = id,
    lastUpdated = lastUpdated,
    name = name,
    runningCompetitions = runningCompetitions.map { tournament ->
        tournament.toDomain()
    },
    shortName = shortName,
    squad = squad.map { squad ->
        squad.toDomain()
    },
    staff = emptyList(),
    tla = tla,
    venue = venue,
    website = website,
)

fun AreaResponse.toDomain(): AreaModel = AreaModel(
    code = code,
    flag = flag,
    id = id,
    name = name,
)

fun CoachResponse?.toDomain(): Coach = Coach(
    contract = this?.contract.toDomain(),
    dateOfBirth = this?.dateOfBirth ?: "",
    firstName = this?.firstName ?: "",
    id = this?.id ?: 0,
    lastName = this?.lastName ?: "",
    name = this?.name ?: "",
    nationality = this?.nationality ?: "",
)

fun ContractResponse?.toDomain(): Contract = Contract(
    start = this?.start.toString(),
    until = this?.until.toString(),
)

fun RunningCompetitionResponse.toDomain(): RunningCompetition = RunningCompetition(
    code = code,
    emblem = emblem.orEmpty(),
    id = id,
    name = name,
    type = type,
)

fun SquadResponse.toDomain(): Squad = Squad(
    dateOfBirth = dateOfBirth,
    id = id,
    name = name,
    nationality = nationality,
    position = position,
)

// TODO: Экран всех матчей

fun MatchesModelResponse.toDomain(): MatchesModel = MatchesModel(
    competition = competition.toDomain(),
    filters = filters.toDomain(),
    matches = matches.map { matches ->
        matches.toDomain()
    },
    resultSet = resultSet.toDomain(),
)

fun CompetitionResponse.toDomain(): CompetitionModel = CompetitionModel(
    code = code,
    emblem = emblem,
    id = id,
    name = name,
    type = type,
)

fun FiltersResponse.toDomain(): FiltersModel = FiltersModel(
    season = season,
)

fun MatchesResponse.toDomain(): Matches = Matches(
    area = area.toDomain(),
    awayTeam = awayTeam.toDomain(),
    competition = competition.toDomain(),
    group = group,
    homeTeam = homeTeam.toDomain(),
    id = id,
    lastUpdated = lastUpdated,
    matchday = matchday,
    odds = odds.toDomain(),
    referees = referees.map { referees ->
        referees.toDomain()
    },
    score = score.toDomain(),
    season = season.toDomain(),
    stage = stage,
    status = status,
    utcDate = utcDate,
)

fun AwayTeamResponse.toDomain() : TeamModel = TeamModel(
    crest = crest,
    id = id,
    name = name,
    shortName = shortName,
    tla = tla,
)

fun HomeTeamResponse.toDomain() : TeamModel = TeamModel(
    crest = crest,
    id = id,
    name = name,
    shortName = shortName,
    tla = tla,
)

fun OddsResponse.toDomain() : OddsModel = OddsModel(
    msg = msg,
)

fun RefereeResponse.toDomain() : RefereeModel = RefereeModel(
    id = id,
    name = name,
    nationality = nationality,
    type = type,
)

fun ScoreResponse.toDomain() : ScoreModel = ScoreModel(
    duration = duration,
    extraTime = extraTime?.toDomain(),
    fullTime = fullTime.toDomain(),
    halfTime = halfTime.toDomain(),
    penalties = penalties?.toDomain(),
    regularTime = regularTime?.toDomain(),
    winner = winner.orEmpty(),
)

fun ExtraTimeResponse.toDomain() : TimeModel = TimeModel(
    away = away,
    home = home,
)

fun FullTimeResponse.toDomain() : TimeModel = TimeModel(
    away = away,
    home = home,
)

fun HalfTimeResponse.toDomain() : TimeModel = TimeModel(
    away = away,
    home = home,
)

fun PenaltiesResponse.toDomain() : TimeModel = TimeModel(
    away = away,
    home = home,
)

fun RegularTimeResponse.toDomain() : TimeModel = TimeModel(
    away = away,
    home = home,
)

fun SeasonResponse.toDomain() : SeasonModel = SeasonModel(
    currentMatchday = currentMatchday,
    endDate = endDate,
    id = id,
    startDate = startDate,
    winner = winner ?: "",
)

fun ResultSetResponse.toDomain() : ResultSetModel = ResultSetModel(
    count = count,
    first = first,
    last = last,
    played = played,
)

// TODO: Экран всех матчей отдельной команды

fun TeamMatchesResponse.toDomain() : TeamMatchesModel = TeamMatchesModel(
    filters = filters.toDomain(),
    matches = matches.map { matches ->
        matches.toDomain()
    },
    resultSet = resultSet.toDomain(),
)

fun FiltersTeamMatchesResponse.toDomain() : FiltersTeamMatchesModel = FiltersTeamMatchesModel(
    competitions = competitions,
    limit = limit,
    permission = permission,
)

fun ResultSetTeamMatchesResponse.toDomain() : ResultSetTeamMatchesModel = ResultSetTeamMatchesModel(
    competitions = competitions,
    count = count,
    draws = draws,
    first = first,
    last = last,
    losses = losses,
    played = played,
    wins = wins,
)

// TODO: Экран бомбардиров

fun ScorersResponse.toDomain() : ScorersModel = ScorersModel(
    competition = competition.toDomain(),
    count = count,
    filters = filters.toDomain(),
    scorers = scorers.map { scorers ->
        scorers.toDomain()
    },
    season = season.toDomain(),
)

fun FiltersScorersResponse.toDomain() : FiltersScorersModel = FiltersScorersModel(
    limit = limit,
    season = season,
)

fun ScorerResponse.toDomain() : ScorerModel = ScorerModel(
    assists = assists,
    goals = goals,
    penalties = penalties,
    player = player.toDomain(),
    team = team.toDomain(),
)

fun PlayerResponse.toDomain() : PlayerModel = PlayerModel(
    dateOfBirth = dateOfBirth,
    firstName = firstName,
    id = id,
    lastName = lastName,
    lastUpdated = lastUpdated,
    name = name,
    nationality = nationality,
    position = position,
    shirtNumber = shirtNumber,
)

fun TeamResponse.toDomain() : TeamScorersModel = TeamScorersModel(
    address = address,
    clubColors = clubColors,
    crest = crest,
    founded = founded,
    id = id,
    lastUpdated = lastUpdated,
    name = name,
    shortName = shortName,
    tla = tla,
    venue = venue,
    website = website,
)
