package com.example.footballapp.data.mapper

import com.example.footballapp.data.model.chempionship.detail_team.DetailTeamResponse
import com.example.footballapp.data.model.chempionship.detail_team.CoachResponse
import com.example.footballapp.data.model.chempionship.detail_team.ContractResponse
import com.example.footballapp.data.model.chempionship.detail_team.RunningCompetitionResponse
import com.example.footballapp.data.model.chempionship.detail_team.SquadResponse
import com.example.footballapp.data.model.chempionship.matches.AreaResponse
import com.example.footballapp.domain.model.detail_team.TeamDetailModel
import com.example.footballapp.domain.model.detail_team.Area
import com.example.footballapp.domain.model.detail_team.Coach
import com.example.footballapp.domain.model.detail_team.Contract
import com.example.footballapp.domain.model.detail_team.RunningCompetition
import com.example.footballapp.domain.model.detail_team.Squad

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

fun AreaResponse.toDomain(): Area = Area(
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
